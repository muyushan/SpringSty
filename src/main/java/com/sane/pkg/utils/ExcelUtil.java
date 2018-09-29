package com.sane.pkg.utils;


import com.sane.pkg.beans.commons.ExcelExportField;
import com.sane.pkg.beans.commons.ExcelField;
import com.sane.pkg.exceptions.BizException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import  java.lang.String;

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

    public  static <T>void  exportExcel(String fileName, List<T> dataList, Class claz,HttpServletResponse response){


        try {
            OutputStream os = response.getOutputStream();
            HSSFWorkbook workbook;
            workbook= generateWorkbook(dataList,claz);
            response.reset();// 清空输出流
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            if(StringUtils.isEmpty(fileName)){
                fileName = sdf.format(new Date());
            }

            fileName= URLEncoder.encode(fileName,"UTF-8");
            response.setHeader("Content-disposition","attachment;filename="+fileName+".xls");
            // 生成提示信息，
            response.setContentType("application/vnd.ms-excel");
            workbook.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            logger.info(ExceptionUtils.getMessage(e));
        }

    }
    /**
     * 读取解析Excel文件所用的方法
     * */
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

    /**
     * 导出Excel文件所用的方法
     */

    private  static <T>HSSFWorkbook generateWorkbook(List<T> dataList,Class<T> claz) throws Exception{
        HSSFWorkbook wb=new HSSFWorkbook();
        Field[] fields = claz.getDeclaredFields();
        List<String> titleList = new ArrayList<String>();
        for (Field field : fields) {
            ExcelExportField excelExportField = field.getAnnotation(ExcelExportField.class);
            if (excelExportField != null) {
                if(titleList.contains(excelExportField.displayName())){
                    throw new Exception("Excel导处类:"+claz.getSimpleName()+"存在重复的列名称:"+excelExportField.displayName());
                }
                titleList.add(excelExportField.displayName());
            }
        }

        HSSFSheet sheet = wb.createSheet("Sheet1");
        sheet.setDefaultRowHeightInPoints((short) 20);
        sheet.setDefaultColumnWidth(10);
        Row titleRow = sheet.createRow(0);
        titleRow.setHeightInPoints((short) 30);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFillForegroundColor(HSSFColor.YELLOW.index);
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(HSSFColor.BLUE.index);
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(HSSFColor.BLUE.index);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(HSSFColor.BLUE.index);
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(HSSFColor.BLUE.index);
        for(int i=0;i<titleList.size();i++){
           Cell cell=titleRow.createCell(i);
           cell.setCellValue(new HSSFRichTextString(titleList.get(i)));
           cell.setCellStyle(style);
        }

        for (int i=0;i<dataList.size();i++){
            HSSFRow dataRow = sheet.createRow(i+1);
            dataRow.setHeightInPoints(20);
            T instant=dataList.get(i);
            int cellIndex=0;
            for (Field field : fields) {
                ExcelExportField excelExportField = field.getAnnotation(ExcelExportField.class);
                if (excelExportField != null) {
                    field.setAccessible(true);
                    HSSFCell cell=null;
                    switch (excelExportField.fieldType()){
                        case STRING:
                            String stringValue=field.get(instant).toString();
                            cell= dataRow.createCell(cellIndex,CellType.STRING);
                            cell.setCellValue(stringValue);
                            break;
                        case DOUBLE:
                           double doubleValue=Double.parseDouble(field.get(instant).toString());
                            cell= dataRow.createCell(cellIndex,CellType.NUMERIC);
                            cell.setCellValue(doubleValue);
                            break;
                        case INT:
                            int intValue=Integer.parseInt(field.get(instant).toString());
                            cell= dataRow.createCell(cellIndex,CellType.NUMERIC);
                            cell.setCellValue(intValue);
                            break;
                        case SHORT:
                            Short shortValue=field.getShort(instant);
                            cell= dataRow.createCell(cellIndex,CellType.STRING);
                            cell.setCellValue(shortValue);
                            break;
                        case DATETIME:
                            Date date=(Date) field.get(instant);
                            cell= dataRow.createCell(cellIndex,CellType.STRING);
                            cell.setCellValue(DateFormatUtils.format(date,excelExportField.formatPatten()));
                            break;
                    }
                    cellIndex++;
                }
            }
        }
        return  wb;
    }

}
