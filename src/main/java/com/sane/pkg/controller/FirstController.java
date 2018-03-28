package com.sane.pkg.controller;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FirstController {
    private Logger logger = Logger.getLogger(FirstController.class);
    @RequestMapping("/main")
    public  String main(@RequestPart("pic")MultipartFile pic, String uname){
        logger.info(pic.getName());
        logger.info(pic.getOriginalFilename());
        logger.info(pic.getSize());
        try {
            FileUtils.forceMkdir(new File("D:\\upload\\pic"));
            FileUtils.writeByteArrayToFile(new File("D:\\upload\\pic\\"+pic.getOriginalFilename()),pic.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        pic.transferTo(new File("D:\\"));
        return "main";
    }
}
