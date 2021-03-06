package com.sane.pkg.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

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
             /* 从当时时间MD5强制重命名图片*/
            String pic_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String pic_type = pic.getContentType();
            String file_ture_name = DigestUtils.md5DigestAsHex(pic_time.getBytes());
            if(pic_type.equals("image/jpeg")){
                file_ture_name =   file_ture_name.concat(".jpg");
            } else if (pic_type.equals("image/png")){
                file_ture_name = file_ture_name.concat(".png");
            } else if(pic_type.equals("image/bmp")){
                file_ture_name =  file_ture_name.concat(".bmp");
            } else if(pic_type.equals("image/gif")){
                file_ture_name = file_ture_name.concat(".gif");
            } else {file_ture_name = file_ture_name.concat(".jpg");}
             /*保存文件*/
            pic.transferTo(new File(uploadPath+File.separator+file_ture_name));
            String url= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/upload"+"/pic/"+file_ture_name;
            logger.info(url);
            request.setAttribute("imgurl",url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "main";
    }



}
