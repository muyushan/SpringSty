package com.sane.pkg.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerBillCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CustomerBillCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andStorageProductBillIdIsNull() {
            addCriterion("StorageProductBillId is null");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillIdIsNotNull() {
            addCriterion("StorageProductBillId is not null");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillIdEqualTo(Integer value) {
            addCriterion("StorageProductBillId =", value, "storageProductBillId");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillIdNotEqualTo(Integer value) {
            addCriterion("StorageProductBillId <>", value, "storageProductBillId");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillIdGreaterThan(Integer value) {
            addCriterion("StorageProductBillId >", value, "storageProductBillId");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("StorageProductBillId >=", value, "storageProductBillId");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillIdLessThan(Integer value) {
            addCriterion("StorageProductBillId <", value, "storageProductBillId");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillIdLessThanOrEqualTo(Integer value) {
            addCriterion("StorageProductBillId <=", value, "storageProductBillId");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillIdIn(List<Integer> values) {
            addCriterion("StorageProductBillId in", values, "storageProductBillId");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillIdNotIn(List<Integer> values) {
            addCriterion("StorageProductBillId not in", values, "storageProductBillId");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillIdBetween(Integer value1, Integer value2) {
            addCriterion("StorageProductBillId between", value1, value2, "storageProductBillId");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillIdNotBetween(Integer value1, Integer value2) {
            addCriterion("StorageProductBillId not between", value1, value2, "storageProductBillId");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeIsNull() {
            addCriterion("StorageProductBillCode is null");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeIsNotNull() {
            addCriterion("StorageProductBillCode is not null");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeEqualTo(String value) {
            addCriterion("StorageProductBillCode =", value, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeNotEqualTo(String value) {
            addCriterion("StorageProductBillCode <>", value, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeGreaterThan(String value) {
            addCriterion("StorageProductBillCode >", value, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeGreaterThanOrEqualTo(String value) {
            addCriterion("StorageProductBillCode >=", value, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeLessThan(String value) {
            addCriterion("StorageProductBillCode <", value, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeLessThanOrEqualTo(String value) {
            addCriterion("StorageProductBillCode <=", value, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeLike(String value) {
            addCriterion("StorageProductBillCode like", value, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeNotLike(String value) {
            addCriterion("StorageProductBillCode not like", value, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeIn(List<String> values) {
            addCriterion("StorageProductBillCode in", values, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeNotIn(List<String> values) {
            addCriterion("StorageProductBillCode not in", values, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeBetween(String value1, String value2) {
            addCriterion("StorageProductBillCode between", value1, value2, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andStorageProductBillCodeNotBetween(String value1, String value2) {
            addCriterion("StorageProductBillCode not between", value1, value2, "storageProductBillCode");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("Quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("Quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Double value) {
            addCriterion("Quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Double value) {
            addCriterion("Quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Double value) {
            addCriterion("Quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Double value) {
            addCriterion("Quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Double value) {
            addCriterion("Quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Double value) {
            addCriterion("Quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Double> values) {
            addCriterion("Quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Double> values) {
            addCriterion("Quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Double value1, Double value2) {
            addCriterion("Quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Double value1, Double value2) {
            addCriterion("Quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("TotalPrice is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("TotalPrice is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(Double value) {
            addCriterion("TotalPrice =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(Double value) {
            addCriterion("TotalPrice <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(Double value) {
            addCriterion("TotalPrice >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("TotalPrice >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(Double value) {
            addCriterion("TotalPrice <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(Double value) {
            addCriterion("TotalPrice <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<Double> values) {
            addCriterion("TotalPrice in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<Double> values) {
            addCriterion("TotalPrice not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(Double value1, Double value2) {
            addCriterion("TotalPrice between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(Double value1, Double value2) {
            addCriterion("TotalPrice not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeIsNull() {
            addCriterion("CustomerCode is null");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeIsNotNull() {
            addCriterion("CustomerCode is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeEqualTo(String value) {
            addCriterion("CustomerCode =", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotEqualTo(String value) {
            addCriterion("CustomerCode <>", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeGreaterThan(String value) {
            addCriterion("CustomerCode >", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CustomerCode >=", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeLessThan(String value) {
            addCriterion("CustomerCode <", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeLessThanOrEqualTo(String value) {
            addCriterion("CustomerCode <=", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeLike(String value) {
            addCriterion("CustomerCode like", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotLike(String value) {
            addCriterion("CustomerCode not like", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeIn(List<String> values) {
            addCriterion("CustomerCode in", values, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotIn(List<String> values) {
            addCriterion("CustomerCode not in", values, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeBetween(String value1, String value2) {
            addCriterion("CustomerCode between", value1, value2, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotBetween(String value1, String value2) {
            addCriterion("CustomerCode not between", value1, value2, "customerCode");
            return (Criteria) this;
        }

        public Criteria andBillStatusIsNull() {
            addCriterion("BillStatus is null");
            return (Criteria) this;
        }

        public Criteria andBillStatusIsNotNull() {
            addCriterion("BillStatus is not null");
            return (Criteria) this;
        }

        public Criteria andBillStatusEqualTo(String value) {
            addCriterion("BillStatus =", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotEqualTo(String value) {
            addCriterion("BillStatus <>", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusGreaterThan(String value) {
            addCriterion("BillStatus >", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusGreaterThanOrEqualTo(String value) {
            addCriterion("BillStatus >=", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLessThan(String value) {
            addCriterion("BillStatus <", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLessThanOrEqualTo(String value) {
            addCriterion("BillStatus <=", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLike(String value) {
            addCriterion("BillStatus like", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotLike(String value) {
            addCriterion("BillStatus not like", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusIn(List<String> values) {
            addCriterion("BillStatus in", values, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotIn(List<String> values) {
            addCriterion("BillStatus not in", values, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusBetween(String value1, String value2) {
            addCriterion("BillStatus between", value1, value2, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotBetween(String value1, String value2) {
            addCriterion("BillStatus not between", value1, value2, "billStatus");
            return (Criteria) this;
        }

        public Criteria andOutQuantityIsNull() {
            addCriterion("OutQuantity is null");
            return (Criteria) this;
        }

        public Criteria andOutQuantityIsNotNull() {
            addCriterion("OutQuantity is not null");
            return (Criteria) this;
        }

        public Criteria andOutQuantityEqualTo(Double value) {
            addCriterion("OutQuantity =", value, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityNotEqualTo(Double value) {
            addCriterion("OutQuantity <>", value, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityGreaterThan(Double value) {
            addCriterion("OutQuantity >", value, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityGreaterThanOrEqualTo(Double value) {
            addCriterion("OutQuantity >=", value, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityLessThan(Double value) {
            addCriterion("OutQuantity <", value, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityLessThanOrEqualTo(Double value) {
            addCriterion("OutQuantity <=", value, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityIn(List<Double> values) {
            addCriterion("OutQuantity in", values, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityNotIn(List<Double> values) {
            addCriterion("OutQuantity not in", values, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityBetween(Double value1, Double value2) {
            addCriterion("OutQuantity between", value1, value2, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andOutQuantityNotBetween(Double value1, Double value2) {
            addCriterion("OutQuantity not between", value1, value2, "outQuantity");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CreateDate is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CreateDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CreateDate =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CreateDate <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CreateDate >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateDate >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CreateDate <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CreateDate <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CreateDate in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CreateDate not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CreateDate between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CreateDate not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("Creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("Creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("Creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("Creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("Creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("Creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("Creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("Creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("Creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("Creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("Creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("Creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("Creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("Creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNull() {
            addCriterion("ModifyDate is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("ModifyDate is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(Date value) {
            addCriterion("ModifyDate =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(Date value) {
            addCriterion("ModifyDate <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(Date value) {
            addCriterion("ModifyDate >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("ModifyDate >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(Date value) {
            addCriterion("ModifyDate <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(Date value) {
            addCriterion("ModifyDate <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<Date> values) {
            addCriterion("ModifyDate in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<Date> values) {
            addCriterion("ModifyDate not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(Date value1, Date value2) {
            addCriterion("ModifyDate between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(Date value1, Date value2) {
            addCriterion("ModifyDate not between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyerIsNull() {
            addCriterion("Modifyer is null");
            return (Criteria) this;
        }

        public Criteria andModifyerIsNotNull() {
            addCriterion("Modifyer is not null");
            return (Criteria) this;
        }

        public Criteria andModifyerEqualTo(String value) {
            addCriterion("Modifyer =", value, "modifyer");
            return (Criteria) this;
        }

        public Criteria andModifyerNotEqualTo(String value) {
            addCriterion("Modifyer <>", value, "modifyer");
            return (Criteria) this;
        }

        public Criteria andModifyerGreaterThan(String value) {
            addCriterion("Modifyer >", value, "modifyer");
            return (Criteria) this;
        }

        public Criteria andModifyerGreaterThanOrEqualTo(String value) {
            addCriterion("Modifyer >=", value, "modifyer");
            return (Criteria) this;
        }

        public Criteria andModifyerLessThan(String value) {
            addCriterion("Modifyer <", value, "modifyer");
            return (Criteria) this;
        }

        public Criteria andModifyerLessThanOrEqualTo(String value) {
            addCriterion("Modifyer <=", value, "modifyer");
            return (Criteria) this;
        }

        public Criteria andModifyerLike(String value) {
            addCriterion("Modifyer like", value, "modifyer");
            return (Criteria) this;
        }

        public Criteria andModifyerNotLike(String value) {
            addCriterion("Modifyer not like", value, "modifyer");
            return (Criteria) this;
        }

        public Criteria andModifyerIn(List<String> values) {
            addCriterion("Modifyer in", values, "modifyer");
            return (Criteria) this;
        }

        public Criteria andModifyerNotIn(List<String> values) {
            addCriterion("Modifyer not in", values, "modifyer");
            return (Criteria) this;
        }

        public Criteria andModifyerBetween(String value1, String value2) {
            addCriterion("Modifyer between", value1, value2, "modifyer");
            return (Criteria) this;
        }

        public Criteria andModifyerNotBetween(String value1, String value2) {
            addCriterion("Modifyer not between", value1, value2, "modifyer");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("Remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("Remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("Remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("Remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("Remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("Remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("Remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("Remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("Remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("Remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("Remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("Remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("Remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("Remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}