package com.sane.pkg.utils;

import com.sane.pkg.beans.UserInfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {
   public static String CURRENT_USER="CURRENT_USER";
    public  static void  setCurrentUserInfo(HttpServletRequest request, UserInfo userInfo){
       HttpSession session= request.getSession();
       if(userInfo==null){
           session.removeAttribute(CURRENT_USER);
       }else{
           session.setAttribute(CURRENT_USER,userInfo.getEmailPhone());
       }

    }
    public  static String  getCurrentUserInfo(HttpServletRequest request)throws Exception{

        HttpSession session= request.getSession(false);
        if(null==session){
        throw  new Exception("登录信息超时请重新登录");
        }
       Object obj= session.getAttribute(CURRENT_USER);
        if(obj==null){
            throw  new Exception("登录信息超时请重新登录");
        }
      String userName=  session.getAttribute(CURRENT_USER).toString();
        return  userName;
    }

    public static  String getCurrentUserInfo()throws Exception{
        HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return  getCurrentUserInfo(request);
    }

    public static   Object getSessionAttribute(HttpServletRequest request,String attr){
        return  request.getSession().getAttribute(attr);
    }

    public  static   String getWebRoot(HttpServletRequest request){
        StringBuffer sbRoot = new StringBuffer(50);
        //表示的是‘http’
        String protocol = request.getProtocol();
        //表示的是ip、或者是localhost
        int port = request.getServerPort();
        //获取对应的项目的名称
        String serverName = request.getServerName();
        sbRoot.append(serverName);
        if(protocol.toLowerCase().startsWith("https")){
            sbRoot.insert(0, "https://");
            if(port != 443){
                sbRoot.append(":").append(port);
            }
        }else if(protocol.toLowerCase().startsWith("http")){
            sbRoot.insert(0, "http://");
            if(port != 80){
                sbRoot.append(":").append(port);
            }
        }

        String strContextPath = request.getContextPath();
        if (strContextPath != null && !strContextPath.equals("/")){
            sbRoot.append(strContextPath);
        }

        sbRoot.append("/");
        return sbRoot.toString();

    }
}
