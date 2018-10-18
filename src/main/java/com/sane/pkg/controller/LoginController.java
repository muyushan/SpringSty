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
            request.getSession().setAttribute("WebRoot",SessionUtil.getWebRoot(request));
        }
        catch (Exception e){
            msgBean=new MsgBean();
            msgBean.setCode(MsgBean.FAIL);
            msgBean.setMessage(ExceptionUtils.getMessage(e));
        }
        return  msgBean;

    }

    @RequestMapping("redirect_to_workspcae")
    public  String toWorkSpace(){
        return "workspace";
    }

    @RequestMapping("logOut")
    public String logOut(HttpServletRequest request){
        SessionUtil.setCurrentUserInfo(request,null);
        request.getSession().invalidate();
        return "redirect:showLogin.do";
    }
}
