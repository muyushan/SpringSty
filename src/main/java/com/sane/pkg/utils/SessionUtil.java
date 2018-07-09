package com.sane.pkg.utils;

import com.sane.pkg.beans.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {
   public static String CURRENT_USER="CURRENT_USER";
    public  static void  setCurrentUserInfo(HttpServletRequest request, UserInfo userInfo){
       HttpSession session= request.getSession();
       session.setAttribute(CURRENT_USER,userInfo.getEmailPhone());
    }
    public  static String  getCurrentUserInfo(HttpServletRequest request)throws Exception{
        HttpSession session= request.getSession(false);
        if(null==session){
        throw  new Exception("登录信息超时请重新登录");
        }
      String userName=  session.getAttribute(CURRENT_USER).toString();
        return  userName;
    }
}
