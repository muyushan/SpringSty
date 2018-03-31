package com.sane.pkg.controller;

import com.sane.pkg.exception.ItemDuplicateException;
import com.sane.pkg.exception.ItemNotFoundException;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
    @RequestMapping("redirect")
    public String redirect(RedirectAttributes redirectAttributes){

        redirectAttributes.addAttribute("attr1","a1");
        redirectAttributes.addFlashAttribute("flashattr","flash1");
        return  "redirect:re.jsp";
    }

@RequestMapping("finditem")
    public  String findItem(@RequestParam String id, Model model){

        if(id.equals("1")){
            throw  new ItemNotFoundException();
        }


        model.addAttribute("item",id);
        return "itemView";
    }
    @RequestMapping("add")
    public  String addItem(){
        if(true){
            throw new ItemDuplicateException();
        }

        return "itemView";
    }

//    @ExceptionHandler(ItemNotFoundException.class)
//    public  String handlerNotFoundItemException(){
//        return "error/itemlost";
//    }


}
