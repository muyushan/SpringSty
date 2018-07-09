package com.sane.pkg.service;

import com.sane.pkg.beans.UserInfo;
import com.sane.pkg.beans.commons.MsgBean;

public interface UserService {

    public  int addUser(UserInfo user);
    public MsgBean checkLogin(UserInfo userInfo) throws Exception;
}
