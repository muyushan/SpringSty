package com.sane.pkg.controller;

import com.sane.pkg.beans.UserInfo;
import com.sane.pkg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("toRegist")
    public  String toRegistPage(){
        return"user/registUser";
    }
    @RequestMapping("/regist")
    public String registUser(UserInfo user){
       int result=userService.addUser(user);
       if(result==1){
           return "user/success";
       }else{
           return "user/faile";
       }


    }
}
