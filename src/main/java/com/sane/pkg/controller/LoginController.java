package com.sane.pkg.controller;

import com.sane.pkg.beans.UserInfo;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.service.UserService;
import com.sane.pkg.utils.SessionUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("showLogin")
    public  String showLoginPage(){
        return  "login";
    }
    @RequestMapping("login")
    @ResponseBody
    public  MsgBean doLogin(UserInfo userInfo, HttpServletRequest request){
        MsgBean msgBean=null;
        try{
            msgBean=userService.checkLogin(userInfo);
            if(StringUtils.equals(msgBean.getCode(),MsgBean.SUCCESS)){
                SessionUtil.setCurrentUserInfo(request,userInfo);
            }

            request.getSession().setAttribute("WebRoot",getWebRoot(request));
        }
        catch (Exception e){
            msgBean=new MsgBean();
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage(ExceptionUtils.getMessage(e));
        }
        return  msgBean;

    }
    private  String getWebRoot(HttpServletRequest request){
        StringBuffer sbRoot = new StringBuffer(50);
        String protocol = request.getProtocol();//表示的是‘http’
        int port = request.getServerPort();//表示的是ip、或者是localhost
        String serverName = request.getServerName();//获取对应的项目的名称
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
    @RequestMapping("redirect_to_workspcae")
    public  String toWorkSpace(){
        return "workspace";
    }
}
