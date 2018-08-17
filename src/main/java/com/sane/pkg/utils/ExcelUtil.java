package com.sane.pkg.utils;


import com.sane.pkg.beans.commons.ExcelField;
import com.sane.pkg.exceptions.BizException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class ExcelUtil {
    private  static Log logger= LogFactory.getLog(ExcelUtil.class);
    private static  String EXCEL_XLS="xls";
    private static  String EXCEL_XLSX="xlsx";

    public  static <T>List<T>readExcel(InputStream inputStream, File excelFile, Class<T> claz) throws Exception{
        List<T>returnList=new ArrayList<T>();
        validateExcelFile(excelFile);
        Workbook workbook=resolveWorkBook(inputStream,excelFile);
        return resolveDate(claz, returnList, workbook);
    }

    public  static <T>List<T>readExcel(InputStream inputStream, MultipartFile excelFile, Class<T> claz)throws  Exception{

        List<T>returnList=new ArrayList<T>();
        validateExcelFile(excelFile);
        Workbook workbook=resolveWorkBook(inputStream,excelFile);
        return resolveDate(claz, returnList, workbook);

    }

    private static <T> List<T> resolveDate(Class<T> claz, List<T> returnList, Workbook workbook) throws InstantiationException, IllegalAccessException {
        Sheet sheet=workbook.getSheetAt(0);
        Row titleRow=sheet.getRow(0);
        logger.info(titleRow.getLastCellNum());
        if(sheet.getLastRowNum()==sheet.getFirstRowNum()){
            return  returnList;
        }else{
            Field[]fields=claz.getDeclaredFields();
            Map<String,ExcelField> excelFieldMap=new HashMap<String, ExcelField>();
            for(Field field:fields){
                ExcelField excelField=field.getAnnotation(ExcelField.class);
                if(excelField!=null){
                    excelFieldMap.put(excelField.displayName(),excelField);
                }
            }

            for(int i=1;i<=sheet.getLastRowNum();i++){
                Row row=sheet.getRow(i);
                T instance=claz.newInstance();
                for(int j=0;j<row.getLastCellNum();j++){
                    String title=titleRow.getCell(j).getStringCellValue();
                    if(excelFieldMap.containsKey(title)){
                        ExcelField excelField=excelFieldMap.get(title);
                        for(Field field:fields){
                            ExcelField efield=field.getAnnotation(ExcelField.class);
                            if(efield!=null&&efield.displayName().equals(excelField.displayName())){
                                field.setAccessible(true);
                                switch (excelField.fieldType()){
                                    case STRING:
                                        if(row.getCell(j).getCellTypeEnum().equals(CellType.STRING)){
                                            field.set(instance, row.getCell(j).getStringCellValue());
                                        }else if(row.getCell(j).getCellTypeEnum().equals(CellType.NUMERIC)){
                                            field.set(instance, row.getCell(j).getNumericCellValue());
                                        }

                                        break;
                                    case DOUBLE:
                                        if(row.getCell(j).getCellTypeEnum().equals(CellType.STRING)){
                                            field.setDouble(instance, Double.parseDouble(row.getCell(j).getStringCellValue()));
                                        }else if(row.getCell(j).getCellTypeEnum().equals(CellType.NUMERIC)){
                                            field.setDouble(instance, row.getCell(j).getNumericCellValue());
                                        }
                                        break;
                                    case INT:
                                        if(row.getCell(j).getCellTypeEnum().equals(CellType.STRING)){
                                            field.setInt(instance, Integer.parseInt(row.getCell(j).getStringCellValue()));
                                        }else if(row.getCell(j).getCellTypeEnum().equals(CellType.NUMERIC)){
                                            field.setInt(instance, BigDecimal.valueOf(row.getCell(j).getNumericCellValue()).intValue());
                                        }
                                        break;
                                    case SHORT:
                                        if(row.getCell(j).getCellTypeEnum().equals(CellType.STRING)){
                                            field.set(instance, Short.parseShort(row.getCell(j).getStringCellValue()));
                                        }else if(row.getCell(j).getCellTypeEnum().equals(CellType.NUMERIC)){
                                            field.set(instance, BigDecimal.valueOf(row.getCell(j).getNumericCellValue()).shortValue());
                                        }
                                        break;
                                    case DATETIME:
                                        if(row.getCell(j).getCellTypeEnum().equals(CellType.STRING)){
                                            field.set(instance,row.getCell(j).getDateCellValue());
                                        }
                                        break;
                                }

                            }
                        }
                    }
                }
                returnList.add(instance);
            }
        }
        return returnList;
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

    private static Workbook resolveWorkBook(InputStream inputStream,File file) throws IOException{

        Workbook wb=null;
        if(file.getName().endsWith(EXCEL_XLS)){
            wb=new HSSFWorkbook(inputStream);
        }else if(file.getName().endsWith(EXCEL_XLSX)){
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
