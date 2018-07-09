package com.sane.pkg.serviceimpl;

import com.sane.pkg.beans.UserInfo;
import com.sane.pkg.beans.UserInfoCriteria;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.dao.mappers.UserInfoMapper;
import com.sane.pkg.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public int addUser(UserInfo user) {
         return userInfoMapper.insertSelective(user);
    }

    @Override
    public MsgBean checkLogin(UserInfo userInfo) throws Exception{
        MsgBean msgBean=new MsgBean();
        if(StringUtils.isEmpty(userInfo.getEmailPhone())){
            msgBean.setCode("501");
            msgBean.setMessage("用户名不能为空");
            return msgBean;
        }
        if(StringUtils.isEmpty(userInfo.getPassword())){
            msgBean.setCode("502");
            msgBean.setMessage("密码不能为空");
            return msgBean;
        }
        UserInfoCriteria userInfoCriteria=new UserInfoCriteria();
        UserInfoCriteria.Criteria criteria=userInfoCriteria.createCriteria();
        criteria.andEmailPhoneEqualTo(userInfo.getEmailPhone());
       List<UserInfo> userInfoList=userInfoMapper.selectByExample(userInfoCriteria);
       if(CollectionUtils.isEmpty(userInfoList)){
           msgBean.setCode("501");
           msgBean.setMessage("系统不存在该用户请核对后登录");
           return msgBean;
       }
       UserInfo existUserInfo=userInfoList.get(0);
       if(existUserInfo.getStatuscode().intValue()==0){
           msgBean.setCode("501");
           msgBean.setMessage("该账户已经注册但是尚未激活请先进行激活");
           return msgBean;
       }
       if(StringUtils.equals(userInfo.getPassword(),existUserInfo.getPassword())){
           msgBean.setCode(MsgBean.SUCCESS);
           return  msgBean;
       }else{
           msgBean.setCode("502");
           msgBean.setMessage("密码不正确");
           return msgBean;
       }
    }
}
