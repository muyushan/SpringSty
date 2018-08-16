package com.sane.pkg.utils;


import com.sane.pkg.exceptions.BizException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public  class ExcelUtil {
    private static  String EXCEL_XLS="xls";
    private static  String EXCEL_XLSX="xlsx";
    public  static <T>List<T>readExcel(InputStream inputStream, File excelFile, Class<T> claz){

        return null;

    }

    public  static <T>List<T>readExcel(InputStream inputStream, MultipartFile excelFile, Class<T> claz)throws  Exception{
        validateExcelFile(excelFile);
        Workbook workbook=resolveWorkBook(inputStream,excelFile);
        Sheet sheet=workbook.getSheetAt(0);
        return null;

    }

    private static Workbook resolveWorkBook(InputStream inputStream,MultipartFile file) throws IOException{

        Workbook wb=null;
        if(file.getOriginalFilename().endsWith(EXCEL_XLS)){

            wb=new HSSFWorkbook(inputStream);
        }else if(file.getOriginalFilename().endsWith(EXCEL_XLSX)){
            wb=new XSSFWorkbook(inputStream);
        }
        return wb;
    }

    private static  void validateExcelFile(MultipartFile file) throws Exception{
        if(file==null){
            throw new BizException("文件不存在");
        }

        if(!(file!=null && (file.getOriginalFilename().endsWith(EXCEL_XLS) || file.getOriginalFilename().endsWith(EXCEL_XLSX)))){
            throw new BizException("文件不是Excel");
        }
    }


    private  static  void validateExcelFile(File file) throws Exception{

        if(!file.exists()){
            throw new BizException("文件不存在");
        }
        if(!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))){
            throw new BizException("文件不是Excel");
        }

    }
}
