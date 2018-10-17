package com.sane.pkg.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sane.pkg.beans.*;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.controller.CustomerController;
import com.sane.pkg.controller.StorageBillController;
import com.sane.pkg.dao.mappers.*;
import com.sane.pkg.dao.mappers.udmappers.BaseProductInfoUDMappper;
import com.sane.pkg.dao.mappers.udmappers.CustomerBillUDMapper;
import com.sane.pkg.dao.mappers.udmappers.StorageProductUDMapper;
import com.sane.pkg.exceptions.BizException;
import com.sane.pkg.service.CustomerBillService;
import com.sane.pkg.service.SeedSevice;
import com.sane.pkg.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class CustomerBillServiceImpl implements CustomerBillService {
    private  static  String STORAGE_TYPE_AIAA="AIAA";
    @Autowired
    private CustomerBillMapper customerBillMapper;
    @Autowired
    private CustomerBillDetailMapper customerBillDetailMapper;
    @Autowired
    private CustomerBillUDMapper customerBillUDMapper;
    @Autowired
    private StorageProductUDMapper storageProductUDMapper;
    @Autowired
    private StorageProductMapper storageProductMapper;
    @Autowired
    private SeedSevice seedService;
    @Autowired
    private BaseProductInfoUDMappper baseProductInfoUDMappper;
    @Autowired
    private StorageInOutRecordMapper storageInOutRecordMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public MsgBean createCustomerBill(CustomerBill customerBill, List<CustomerBillDetail> customerBillDetailList) throws Exception {
        String billCode = seedService.getNewSeedValue("B", 9);
        MsgBean msgBean = new MsgBean();
        CustomerBillCriteria customerBillCriteria = new CustomerBillCriteria();
        CustomerBillCriteria.Criteria criteria = customerBillCriteria.createCriteria();
        criteria.andStorageProductBillCodeEqualTo(billCode);
        List<CustomerBill> customerBillList = customerBillMapper.selectByExample(customerBillCriteria);
        if (!CollectionUtils.isEmpty(customerBillList)) {
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage("已经存在了单据号：" + billCode + "的出库单");
            return msgBean;
        }

        customerBill.setCreator(SessionUtil.getCurrentUserInfo());
        customerBill.setCreateDate(new Date());
        customerBill.setStorageProductBillCode(billCode);
        Double sumQuantity = 0d;
        for (CustomerBillDetail customerBillDetail : customerBillDetailList) {
            customerBillDetail.setStorageProductBillCode(billCode);
            sumQuantity += customerBillDetail.getQuantity();
            customerBillDetailMapper.insertSelective(customerBillDetail);
        }
        customerBill.setQuantity(sumQuantity);
        customerBill.setOutQuantity(0d);
        customerBillMapper.insertSelective(customerBill);
        msgBean.setCode(MsgBean.SUCCESS);
        return msgBean;
    }

    @Override
    public PageInfo<CustomerBillUD> selectCustomBill(CustomerBillParam customerBill) {
        PageHelper.startPage(customerBill.getPage(), customerBill.getLimit());
        PageInfo<CustomerBillUD> pageInfo = new PageInfo<CustomerBillUD>(customerBillUDMapper.queryCustomerBillList(customerBill));
        return pageInfo;
    }

    @Override
    public PageInfo<CustomerBillDetailUD> queryCustomerDetailByBillCode(String billCode) {

        PageInfo<CustomerBillDetailUD> customerBillDetailUDPageInfo = new PageInfo<CustomerBillDetailUD>(customerBillUDMapper.queryCustomerBillDetail(billCode));

        return customerBillDetailUDPageInfo;
    }

    @Transactional(rollbackFor = {BizException.class, Exception.class})
    @Override
    public MsgBean editCustomerBill(CustomerBill customerBill, List<CustomerBillDetail> customerBillDetailList) throws Exception {

        MsgBean msgBean = new MsgBean();
        if (StringUtils.isEmpty(customerBill.getStorageProductBillCode())) {
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage("要更新的出库单编号不能为空");
            return msgBean;
        }
        CustomerBillCriteria customerBillCriteria = new CustomerBillCriteria();
        CustomerBillCriteria.Criteria criteria = customerBillCriteria.createCriteria();
        criteria.andStorageProductBillCodeEqualTo(customerBill.getStorageProductBillCode());
        List<CustomerBill> customerBillList = customerBillMapper.selectByExample(customerBillCriteria);
        if (CollectionUtils.isEmpty(customerBillList)) {
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage("要更新的出库单已经不存在了，请确认");
            return msgBean;
        } else {
            CustomerBill srcCustomerBill = customerBillList.get(0);
            if (!srcCustomerBill.getBillStatus().equals(StorageBillController.BILLSTATUS_AJAA)) {
                msgBean.setCode(MsgBean.FAIL);
                msgBean.setMessage("要更新的出库单状态已经发生改变。不允许继续修改，请确认");
                return msgBean;
            }
        }
        Double sumQuantity = 0d;
        for (CustomerBillDetail customerBillDetail : customerBillDetailList) {
            customerBillDetail.setStorageProductBillCode(customerBill.getStorageProductBillCode());
            sumQuantity += customerBillDetail.getQuantity();
        }
        customerBill.setQuantity(sumQuantity);
        customerBill.setModifyDate(new Date());
        customerBill.setModifyer(SessionUtil.getCurrentUserInfo());
        int count = customerBillMapper.updateByExampleSelective(customerBill, customerBillCriteria);
        if (count == 0) {
            throw new BizException("修改出库单详情失败，错误码:D01");
        }
        CustomerBillDetailCriteria customerBillDetailCriteria = new CustomerBillDetailCriteria();
        CustomerBillDetailCriteria.Criteria detailCriteria = customerBillDetailCriteria.createCriteria();
        detailCriteria.andStorageProductBillCodeEqualTo(customerBill.getStorageProductBillCode());
        count = customerBillDetailMapper.deleteByExample(customerBillDetailCriteria);
        if (count == 0) {
            throw new BizException("修改出库单详情失败，错误码:D02");
        }

        for (CustomerBillDetail detail : customerBillDetailList) {
            count = customerBillDetailMapper.insertSelective(detail);
            if (count == 0) {
                throw new BizException("修改出库单详情失败，错误码:D03");
            }
        }
        msgBean.setCode(MsgBean.SUCCESS);
        return msgBean;
    }

    @Override
    public CustomerBill queryCustomerBillByCode(String billCode) throws BizException {
        CustomerBillCriteria customerBillCriteria = new CustomerBillCriteria();
        CustomerBillCriteria.Criteria criteria = customerBillCriteria.createCriteria();
        criteria.andStorageProductBillCodeEqualTo(billCode);
        List<CustomerBill> customerBillList = customerBillMapper.selectByExample(customerBillCriteria);
        if (CollectionUtils.isEmpty(customerBillList)) {
            return null;
        }
        return customerBillList.get(0);
    }

    @Transactional(rollbackFor = {Exception.class, BizException.class})
    @Override
    public MsgBean auditCustomerBill(List<String> billCodeList) throws BizException, Exception {
        MsgBean msgBean = new MsgBean();
        for (String billCode : billCodeList) {
            CustomerBill customerBill = queryCustomerBillByCode(billCode);
            if (!customerBill.getBillStatus().equals(StorageBillController.BILLSTATUS_AJAA)) {
                throw new BizException("出库单：" + customerBill.getStorageProductBillCode() + "当前状态不是新建待审核状态了，不能继续审核");
            }
            List<CustomerBillDetail> detailList = null;
            CustomerBillDetailCriteria customerBillDetailCriteria = new CustomerBillDetailCriteria();
            CustomerBillDetailCriteria.Criteria customerBillDetailSql = customerBillDetailCriteria.createCriteria();
            customerBillDetailSql.andStorageProductBillCodeEqualTo(billCode);
            detailList = customerBillDetailMapper.selectByExample(customerBillDetailCriteria);
            if (CollectionUtils.isEmpty(detailList)) {
                throw new BizException("出库单：" + customerBill.getStorageProductBillCode() + "没有发现出库单详情，请确认。");
            }
            for (CustomerBillDetail detail : detailList) {
                ProductInfoParam productInfo=new ProductInfoParam();
                productInfo.setProductCode(detail.getProductCode());
                List<ProductInfoUD> productInfoUDList=baseProductInfoUDMappper.queryProductInfoByParam(productInfo);
                ProductInfoUD productInfoUD=productInfoUDList.get(0);
                StorageProductCriteria storageProductCriteria = new StorageProductCriteria();
                StorageProductCriteria.Criteria storageProductCriteriaSql = storageProductCriteria.createCriteria();
                storageProductCriteriaSql.andProductCodeEqualTo(detail.getProductCode());
                storageProductCriteriaSql.andTypeEqualTo(CustomerBillServiceImpl.STORAGE_TYPE_AIAA);
                storageProductCriteriaSql.andQuantityGreaterThan(Double.parseDouble("0"));
                List<StorageProduct> storageProductList = storageProductMapper.selectByExample(storageProductCriteria);
                if (CollectionUtils.isEmpty(storageProductList)) {
                    throw new BizException("出库单：" + customerBill.getStorageProductBillCode() + "所需要的物料：[" + productInfoUD.getProductName()+","+productInfoUD.getFlavourTxt()+","+productInfoUD.getProductCategoryTxt() + "]库存不足。");
                }
                StorageProduct storageProduct = storageProductList.get(0);
                if (storageProduct.getQuantity() >= detail.getQuantity()) {
                    int count = storageProductUDMapper.adjustStorageProductQuantity(storageProduct.getStorageProductId(), -detail.getQuantity(), detail.getQuantity());
                    if (count != 1) {
                        throw new BizException("审核出库单失败，更新库存失败");
                    }
                    StorageInOutRecord storageInOutRecord = new StorageInOutRecord();
                    storageInOutRecord.setInOutType("OUT");
                    storageInOutRecord.setCreateDate(new Date());
                    storageInOutRecord.setCreator(SessionUtil.getCurrentUserInfo());
                    storageInOutRecord.setFormerQuantity(storageProduct.getQuantity().intValue());
                    storageInOutRecord.setInOutCode(seedService.getNewSeedValue("S", 9));
                    storageInOutRecord.setProductCode(storageProduct.getProductCode());
                    storageInOutRecord.setQuantity(detail.getQuantity().intValue());
                    storageInOutRecord.setStorageType(storageProduct.getType());
                    storageInOutRecord.setRemark("库存占用:" + customerBill.getStorageProductBillCode());
                    storageInOutRecordMapper.insertSelective(storageInOutRecord);
                } else {
                    throw new BizException("出库单：" + customerBill.getStorageProductBillCode() + "所需要的物料：[" + productInfoUD.getProductName()+","+productInfoUD.getFlavourTxt()+","+productInfoUD.getProductCategoryTxt() + "]库存不足。");
                }

            }
            CustomerBillCriteria customerBillCriteria = new CustomerBillCriteria();
            CustomerBillCriteria.Criteria customerBillCriteriaSql = customerBillCriteria.createCriteria();
            customerBillCriteriaSql.andStorageProductBillCodeEqualTo(customerBill.getStorageProductBillCode());
            customerBillCriteriaSql.andBillStatusEqualTo(StorageBillController.BILLSTATUS_AJAA);
            CustomerBill customerBillUpdate = new CustomerBill();
            customerBillUpdate.setBillStatus(StorageBillController.BILLSTATUS_AJAB);
            customerBillUpdate.setModifyer(SessionUtil.getCurrentUserInfo());
            customerBillUpdate.setModifyDate(new Date());

            int count = customerBillMapper.updateByExampleSelective(customerBillUpdate, customerBillCriteria);
            if (count != 1) {
                throw new BizException(customerBill.getStorageProductBillCode() + "出库单审核失败。");
            }


        }
        msgBean.setCode(MsgBean.SUCCESS);
        return msgBean;
    }

    @Override
    public MsgBean antiAuditSaleBill(List<String> billCodeList) throws BizException, Exception {

        MsgBean msgBean = new MsgBean();
        for (String billCode : billCodeList) {
            CustomerBill customerBill = queryCustomerBillByCode(billCode);
            if (!customerBill.getBillStatus().equals(StorageBillController.BILLSTATUS_AJAB)) {
                throw new BizException("出库单：" + customerBill.getStorageProductBillCode() + "当前状态不是已审核状态了，不能继续审核");
            }
            List<CustomerBillDetail> detailList = null;
            CustomerBillDetailCriteria customerBillDetailCriteria = new CustomerBillDetailCriteria();
            CustomerBillDetailCriteria.Criteria customerBillDetailSql = customerBillDetailCriteria.createCriteria();
            customerBillDetailSql.andStorageProductBillCodeEqualTo(billCode);
            detailList = customerBillDetailMapper.selectByExample(customerBillDetailCriteria);
            if (CollectionUtils.isEmpty(detailList)) {
                throw new BizException("出库单：" + customerBill.getStorageProductBillCode() + "没有发现出库单详情，请确认。");
            }
            for (CustomerBillDetail detail : detailList) {
                ProductInfoParam productInfo=new ProductInfoParam();
                productInfo.setProductCode(detail.getProductCode());
                List<ProductInfoUD> productInfoUDList=baseProductInfoUDMappper.queryProductInfoByParam(productInfo);
                ProductInfoUD productInfoUD=productInfoUDList.get(0);
                StorageProductCriteria storageProductCriteria = new StorageProductCriteria();
                StorageProductCriteria.Criteria storageProductCriteriaSql = storageProductCriteria.createCriteria();
                storageProductCriteriaSql.andProductCodeEqualTo(detail.getProductCode());
                storageProductCriteriaSql.andTypeEqualTo(CustomerBillServiceImpl.STORAGE_TYPE_AIAA);
                List<StorageProduct> storageProductList = storageProductMapper.selectByExample(storageProductCriteria);
                if (CollectionUtils.isEmpty(storageProductList)) {
                    throw new BizException("出库单：" + customerBill.getStorageProductBillCode() + "所需要的物料：[" + productInfoUD.getProductName()+","+productInfoUD.getFlavourTxt()+","+productInfoUD.getProductCategoryTxt() + "]没有对应的库存信息，无法反审核。");
                }
                StorageProduct storageProduct = storageProductList.get(0);
                if (storageProduct.getPlaceholderQuantity() >= detail.getQuantity()) {
                    int count = storageProductUDMapper.adjustStorageProductQuantity(storageProduct.getStorageProductId(), detail.getQuantity(), -detail.getQuantity());
                    if (count != 1) {
                        throw new BizException("反审核出库单失败，更新库存失败");
                    }
                    StorageInOutRecord storageInOutRecord = new StorageInOutRecord();
                    storageInOutRecord.setInOutType("IN");
                    storageInOutRecord.setCreateDate(new Date());
                    storageInOutRecord.setCreator(SessionUtil.getCurrentUserInfo());
                    storageInOutRecord.setFormerQuantity(storageProduct.getQuantity().intValue());
                    storageInOutRecord.setInOutCode(seedService.getNewSeedValue("S", 9));
                    storageInOutRecord.setProductCode(storageProduct.getProductCode());
                    storageInOutRecord.setQuantity(detail.getQuantity().intValue());
                    storageInOutRecord.setStorageType(storageProduct.getType());
                    storageInOutRecord.setRemark("反审核恢复库存占用:" + customerBill.getStorageProductBillCode());
                    storageInOutRecordMapper.insertSelective(storageInOutRecord);
                } else {
                    throw new BizException("出库单：" + customerBill.getStorageProductBillCode() + "所需要的物料：[" + productInfoUD.getProductName()+","+productInfoUD.getFlavourTxt()+","+productInfoUD.getProductCategoryTxt() + "]占用库存不满足出库单的要求。");
                }

            }
            CustomerBillCriteria customerBillCriteria = new CustomerBillCriteria();
            CustomerBillCriteria.Criteria customerBillCriteriaSql = customerBillCriteria.createCriteria();
            customerBillCriteriaSql.andStorageProductBillCodeEqualTo(customerBill.getStorageProductBillCode());
            customerBillCriteriaSql.andBillStatusEqualTo(StorageBillController.BILLSTATUS_AJAB);
            CustomerBill customerBillUpdate = new CustomerBill();
            customerBillUpdate.setBillStatus(StorageBillController.BILLSTATUS_AJAA);
            customerBillUpdate.setModifyer(SessionUtil.getCurrentUserInfo());
            customerBillUpdate.setModifyDate(new Date());

            int count = customerBillMapper.updateByExampleSelective(customerBillUpdate, customerBillCriteria);
            if (count != 1) {
                throw new BizException(customerBill.getStorageProductBillCode() + "出库单反审核失败。");
            }
        }
        msgBean.setCode(MsgBean.SUCCESS);
        return msgBean;
    }

    @Override
    public MsgBean customerBillConfirm(List<String> billCodeList) throws BizException, Exception {
        MsgBean msgBean = new MsgBean();
        for(String billCode:billCodeList){
           CustomerBill customerBill=queryCustomerBillByCode(billCode);
           if(!customerBill.getBillStatus().equals(StorageBillController.BILLSTATUS_AJAB)){
               throw new BizException("出库单："+billCode+"的当前状态不是已审核状态，不能操作出库确认");
           }
            List<CustomerBillDetail> detailList = null;
            CustomerBillDetailCriteria customerBillDetailCriteria = new CustomerBillDetailCriteria();
            CustomerBillDetailCriteria.Criteria customerBillDetailSql = customerBillDetailCriteria.createCriteria();
            customerBillDetailSql.andStorageProductBillCodeEqualTo(billCode);
            detailList = customerBillDetailMapper.selectByExample(customerBillDetailCriteria);
            for (CustomerBillDetail detail : detailList) {
                detail.setOutQuantity(detail.getQuantity());
                customerBillDetailMapper.updateByPrimaryKey(detail);
                ProductInfoParam productInfo=new ProductInfoParam();
                productInfo.setProductCode(detail.getProductCode());
                List<ProductInfoUD> productInfoUDList=baseProductInfoUDMappper.queryProductInfoByParam(productInfo);
                ProductInfoUD productInfoUD=productInfoUDList.get(0);
                StorageProductCriteria storageProductCriteria = new StorageProductCriteria();
                StorageProductCriteria.Criteria storageProductCriteriaSql = storageProductCriteria.createCriteria();
                storageProductCriteriaSql.andProductCodeEqualTo(detail.getProductCode());
                storageProductCriteriaSql.andTypeEqualTo(CustomerBillServiceImpl.STORAGE_TYPE_AIAA);
                List<StorageProduct> storageProductList = storageProductMapper.selectByExample(storageProductCriteria);

                StorageProduct storageProduct = storageProductList.get(0);
                if (storageProduct.getPlaceholderQuantity() >= detail.getQuantity()) {
                    int count = storageProductUDMapper.adjustStorageProductQuantity(storageProduct.getStorageProductId(), null, -detail.getQuantity());
                    if (count != 1) {
                        throw new BizException("出库扣减库存占用失败");
                    }
                    StorageInOutRecord storageInOutRecord = new StorageInOutRecord();
                    storageInOutRecord.setInOutType("OUT");
                    storageInOutRecord.setCreateDate(new Date());
                    storageInOutRecord.setCreator(SessionUtil.getCurrentUserInfo());
                    storageInOutRecord.setFormerQuantity(storageProduct.getQuantity().intValue());
                    storageInOutRecord.setInOutCode(seedService.getNewSeedValue("S", 9));
                    storageInOutRecord.setProductCode(storageProduct.getProductCode());
                    storageInOutRecord.setQuantity(detail.getQuantity().intValue());
                    storageInOutRecord.setStorageType(storageProduct.getType());
                    storageInOutRecord.setRemark("出库扣减占用:" + customerBill.getStorageProductBillCode());
                    storageInOutRecordMapper.insertSelective(storageInOutRecord);
                } else {
                    throw new BizException("出库单：" + customerBill.getStorageProductBillCode() + "所需要的物料：[" + productInfoUD.getProductName()+","+productInfoUD.getFlavourTxt()+","+productInfoUD.getProductCategoryTxt() + "]占用库存不满足出库单的要求。");
                }

            }
            CustomerBillCriteria customerBillCriteria = new CustomerBillCriteria();
            CustomerBillCriteria.Criteria customerBillCriteriaSql = customerBillCriteria.createCriteria();
            customerBillCriteriaSql.andStorageProductBillCodeEqualTo(customerBill.getStorageProductBillCode());
            customerBillCriteriaSql.andBillStatusEqualTo(StorageBillController.BILLSTATUS_AJAB);
            customerBillCriteriaSql.andStorageProductBillIdEqualTo(customerBill.getStorageProductBillId());
            CustomerBill customerBillUpdate = new CustomerBill();
            customerBillUpdate.setStorageProductBillId(customerBill.getStorageProductBillId());
            customerBillUpdate.setBillStatus(StorageBillController.BILLSTATUS_AJAD);
            customerBillUpdate.setModifyer(SessionUtil.getCurrentUserInfo());
            customerBillUpdate.setModifyDate(new Date());
            customerBillUpdate.setOutQuantity(customerBill.getQuantity());

            int count = customerBillMapper.updateByExampleSelective(customerBillUpdate, customerBillCriteria);
            if (count != 1) {
                throw new BizException(customerBill.getStorageProductBillCode() + "出库确认失败。");
            }
        }
        msgBean.setCode(MsgBean.SUCCESS);
        return msgBean;
    }
}
