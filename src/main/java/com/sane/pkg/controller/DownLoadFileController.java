package com.sane.pkg.controller;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonParser;
import com.sane.pkg.beans.commons.MsgBean;
import com.sane.pkg.exceptions.BizException;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

@RequestMapping("/downloadFile")
@Controller
public class DownLoadFileController {
    private Log logger= LogFactory.getLog(getClass());
    @RequestMapping("{file}/down")
    public void downLoad(@PathVariable("file") String fileName, HttpServletRequest request, HttpServletResponse response) throws  Exception{
        String basePath="/WEB-INF/pages/downloadFile/";
        String filePath=basePath+fileName;
        String realPath=RequestContextUtils.getWebApplicationContext(request).getServletContext().getRealPath(filePath);
        File file=new File(realPath);
        if(!file.exists()){
            MsgBean msgBean=new MsgBean();
            msgBean.setCode("402");
            msgBean.setMessage("未找到文件"+fileName);
            throw  new BizException( JSON.toJSONString(msgBean));
        }
      InputStream fileInputStream=FileUtils.openInputStream(file);
        OutputStream os = response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition","attachment;filename="+fileName);
        response.setContentType("application/vnd.ms-excel");
        int index=0;
        byte[] bytes = new byte[4096];
        while((index= fileInputStream.read(bytes))!= -1){
            os.write(bytes, 0, index);
            os.flush();
        }
        os.close();
        fileInputStream.close();
        logger.info(realPath);

    }
}
