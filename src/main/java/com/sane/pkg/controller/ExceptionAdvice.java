package com.sane.pkg.controller;

import com.sane.pkg.exception.ItemDuplicateException;
import com.sane.pkg.exception.ItemNotFoundException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(ItemNotFoundException.class)
    public String handlerNotFoundItemException(HttpServletRequest request, ItemNotFoundException ex){
        request.setAttribute("errormsg","项目不存在");
        return "error/itemlost";
    }
    @ExceptionHandler(ItemDuplicateException.class)
    public String handlerDuplicateItemException(HttpServletRequest request, ItemDuplicateException ex){
        request.setAttribute("errormsg", "项目已经被创建过了");
        return "error/itemlost";
    }
}
