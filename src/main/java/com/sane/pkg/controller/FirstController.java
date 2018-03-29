package com.sane.pkg.controller;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class FirstController {
    private Logger logger = Logger.getLogger(FirstController.class);
    @RequestMapping("/main") 
    public  String main(@RequestPart("pic")MultipartFile pic, String uname, HttpServletRequest request){
        try {

            String uploadPath=ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("upload"+File.separator+"pic");
            File filePath=new File(uploadPath);
            if(!filePath.exists()){
                FileUtils.forceMkdir(new File(uploadPath));
            }
            pic.transferTo(new File(uploadPath+File.separator+pic.getOriginalFilename()));
            String url= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+File.separator+"upload"+File.separator+"pic"+File.separator+pic.getOriginalFilename();

        logger.info(url);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "main";
    }
}
