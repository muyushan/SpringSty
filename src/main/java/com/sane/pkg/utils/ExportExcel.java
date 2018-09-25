package com.sane.pkg.utils;


import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 韩猛 2015-5-21
 */
@Component
public class ExportExcel<T> {
    private static final Logger logger = LoggerFactory.getLogger(ExportExcel.class);
    /*
	 * 
	 * Controller 调用案例
	 * 
	 * 
	 * @RequestMapping("/test.do") public void test(HttpServletResponse response){ List<Student> dataset2 = new ArrayList<Student>(); dataset2.add(new Student(10000001, "张三", 20, '1', new Date()));
	 * dataset2.add(new Student(20000002, "李四", 24, '1', new Date())); dataset2.add(new Student(30000003, "王五", 22, '1', new Date())); dataset2.add(new Student(30000003, "赵六", 22, '1', new Date()));
	 * dataset2.add(new Student(30000003, "红七", 22, '1', new Date())); dataset2.add(new Student(30000003, "称霸", 22, '1', new Date())); dataset2.add(new Student(30000003, "彩后", 22, '1', new Date()));
	 * dataset2.add(new Student(30000003, "石泉", 22, '1', new Date())); try{ OutputStream os = response.getOutputStream(); HSSFWorkbook workbook = exportExcel.exportExcel(dataset2); // 表名 String
	 * tmptitle = "userdata"; // 标题 response.reset();// 清空输出流 response.setHeader("Content-disposition", "attachment; filename="+tmptitle+".xls");// 设定输出文件头 // 生成提示信息，
	 * response.setContentType("application/vnd.ms-excel"); workbook.write(os); os.flush(); os.close(); } catch (Exception e) { e.printStackTrace(); } }
	 */

    /**
     * 导出excel模板
     */
    public HSSFWorkbook exportExcel(String[] headers, int startRow, int startColumn) {
        return exportExcel("sheet", headers, null, startRow, startColumn);
    }

    /**
     * 导出excel
     *
     * @param dataset 需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。
     */
    public HSSFWorkbook exportExcel(Collection<T> dataset) {
        return exportExcel("sheet", null, dataset, 0, 0);
    }

    public HSSFWorkbook exportExcelStrings(List list) {
        return exportExcel("sheet", null, list, 0, 0);
    }

    /**
     * 导出excel
     *
     * @param headers 表格属性列名数组
     * @param dataset 需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。
     */
    public HSSFWorkbook exportExcel(String[] headers, Collection<T> dataset) {
        return exportExcel("sheet", headers, dataset, 0, 0);
    }

    public HSSFWorkbook exportExcelStrings(String[] headers, List lists) {
        return exportExcelStrings(headers, lists, 0, 0);
    }

    /**
     * 导出excel
     *
     * @param title   表格标题名
     * @param headers 表格属性列名数组
     * @param dataset 需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。
     */
    public HSSFWorkbook exportExcel(String title, String[] headers, Collection<T> dataset, OutputStream out) {
        return exportExcel(title, headers, dataset, 0, 0);
    }

    /**
     * 导出excel
     *
     * @param title       表格标题名 sheet名
     * @param headers     表格属性列名数组
     * @param dataset     需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。
     * @param startRow    起始行数
     * @param startColumn 起始列
     */
    public HSSFWorkbook exportExcel(String title, String[] headers, Collection<T> dataset, int startRow, int startColumn) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(title);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth(15);
        // 产生表格标题行
        if (headers != null) {
            HSSFRow row = sheet.createRow(startRow);
            for (int i = 0; i < headers.length; i++) {
                HSSFCell cell = row.createCell(startColumn + i);
                //cell.setCellStyle(createTitleStyle(workbook));
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }
        } else {
            startRow--;
        }
        if (dataset != null) {
            writeVlueToExcel(sheet, dataset, startRow, startColumn);
        }
        return workbook;
    }

    public HSSFWorkbook exportExcelStringsWithFirstRowTitle(Map<String, List<String[]>> datas, String[] headers) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        for (Map.Entry<String, List<String[]>> sheetData : datas.entrySet()) {
            int startRow = 0;
            // 生成一个表格
            HSSFSheet sheet = workbook.createSheet(sheetData.getKey());
            // 设置表格默认列宽度为15个字节
            sheet.setDefaultColumnWidth(15);
            // 外部获得样式后，再进行循环，不要把样式加入循环中
            CellStyle bigStyle = createFirstRowTitleStyle(workbook);
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headers.length - 1));
            HSSFRow bigTitle = sheet.createRow(startRow++);
            bigTitle.setHeight((short) 350);
            HSSFCell bigCell = bigTitle.createCell(0);
            bigCell.setCellStyle(bigStyle);
            HSSFRichTextString bigText = new HSSFRichTextString(sheetData.getValue().get(0)[0]);
            bigCell.setCellValue(bigText);
            sheetData.getValue().remove(0);

            CellStyle substyle = createFirstRowTitleStyle(workbook);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, headers.length - 1));
            HSSFRow subTitle = sheet.createRow(startRow++);
            subTitle.setHeight((short) 350);
            HSSFCell subCell = subTitle.createCell(0);
            subCell.setCellStyle(substyle);
            HSSFRichTextString subText = new HSSFRichTextString(sheetData.getValue().get(0)[0]);
            subCell.setCellValue(subText);
            sheetData.getValue().remove(0);
            // 产生表格标题行
            HSSFRow row = sheet.createRow(startRow);
            for (int i = 0; i < headers.length; i++) {
                HSSFCell cell = row.createCell(i);
                //cell.setCellStyle(style);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }
            if (sheetData.getValue().size() > 0) {
                writeVlueToExcelStringsWithBigTitle(workbook, sheet, sheetData.getValue(), startRow);
            }
        }
        return workbook;
    }

    private HSSFWorkbook exportExcelStrings(String[] headers, List list, int startRow, int startColumn) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet("sheet");
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth(15);
        // 外部获得样式后，再进行循环，不要把样式加入循环中
        //CellStyle style = createTitleStyle(workbook);
        // 产生表格标题行
        if (headers != null) {
            HSSFRow row = sheet.createRow(startRow);
            for (int i = 0; i < headers.length; i++) {
                HSSFCell cell = row.createCell(startColumn + i);
                //cell.setCellStyle(style);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);

                cell.setCellValue(text);

            }
        } else {
            startRow--;
        }
        if (list != null)
            writeVlueToExcelStrings(workbook, sheet, list, startRow, startColumn);
        return workbook;
    }

    /**
     * 根据模板导出excel
     *
     * @param templatePath 模板路径
     * @param dataset      需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。
     */
    public HSSFWorkbook exportExcel(String templatePath, Collection<T> dataset) {
        HSSFWorkbook workbook = null;
        int startRow = 0;
        int startColumn = 0;
        File f = new File(templatePath);
        try {
            FileInputStream is = new FileInputStream(f);
            workbook = new HSSFWorkbook(is);
            HSSFSheet sheet = workbook.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();// 获得总行数
            for (int i = 0; i < rowNum + 1; i++) {
                if (!isBlankRow(sheet.getRow(i))) {
                    startRow = i;
                    sheet.getRow(i).getCell(1);
                    for (int j = 0; j < 1000; j++) {
                        if (sheet.getRow(i).getCell(j) != null) {
                            startColumn = j;
                            break;
                        }
                    }
                    break;
                }
            }
            writeVlueToExcel(sheet, dataset, startRow, startColumn);
        } catch (Exception e) {
            logger.info(ExceptionUtils.getMessage(e));
        }
        return workbook;
    }



    /**
     * 为工作薄sheet写入值
     *
     * @param sheet       sheet
     * @param dataset     需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。
     * @param startRow    起始行
     * @param startColumn 起始列
     */
    private void writeVlueToExcel(HSSFSheet sheet, Collection<T> dataset, int startRow, int startColumn) {
        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        int index = startRow;
        while (it.hasNext()) {
            index++;
            HSSFRow row = sheet.createRow(index);
            T t = it.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                HSSFCell cell = row.createCell(startColumn + i);
                //cell.setCellStyle(createContentStyle(workbook));
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                try {
                    Class<?> tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName);
                    Object value = getMethod.invoke(t);
                    String textValue = null;
                    if (value instanceof Date) {
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        textValue = sdf.format(date);
                    } else {
                        // 都当作字符串简单处理
                        if (value != null) {
                            textValue = value.toString();
                        }
                    }
                    // 利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(textValue);
                            cell.setCellValue(richString);
                        }
                    }
                } catch (Exception e) {
                    logger.info(ExceptionUtils.getMessage(e));
                }
            }
        }
    }

    private void writeVlueToExcelStringsWithBigTitle(HSSFWorkbook workbook, HSSFSheet sheet, List<String[]> datalist, int startRow) {
        // 遍历集合数据，产生数据行
        // 外部获得样式后，再进行循环，不要把样式加入循环中
        CellStyle style = createContentStyle(workbook);
        HSSFFont font3 = workbook.createFont();
        font3.setColor(HSSFColor.BLUE.index);
        HSSFFont font4 = workbook.createFont();
        font4.setColor(HSSFColor.RED.index);

        int index = startRow;
        for (String[] aDatalist : datalist) {
            index++;
            HSSFRow row = sheet.createRow(index);
            for (int i = 0; i < aDatalist.length; i++) {
                HSSFCell cell = row.createCell(i);
                cell.setCellStyle(style);
                String textValue = aDatalist[i];

                if (textValue != null) {
                    Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                    Matcher matcher = p.matcher(textValue);
                    if (matcher.matches()) {
                        cell.setCellValue(Double.parseDouble(textValue));
                    } else {
                        HSSFRichTextString richString = new HSSFRichTextString(textValue);
                        if (i == 5 && !"0".equals(textValue)) {
                            richString.applyFont(font4);
                        } else {
                            richString.applyFont(font3);
                        }
                        cell.setCellValue(richString);
                    }
                }
            }
        }
    }

    private void writeVlueToExcelPositionStrings(HSSFWorkbook workbook, HSSFSheet sheet, List<String[]> datalist, int startRow, int startColumn) {
        // 遍历集合数据，产生数据行
        // 外部获得样式后，再进行循环，不要把样式加入循环中
        HSSFCellStyle style = sheet.getRow(startRow).getCell(startColumn).getCellStyle();
        ;
        HSSFFont font3 = workbook.createFont();
        font3.setColor(HSSFColor.BLACK.index);
        int index = startRow;
        if (datalist.size() < 100000) {
            for (String[] aDatalist : datalist) {
                index++;
                HSSFRow row = sheet.createRow(index);
                for (int i = 0; i < aDatalist.length; i++) {
                    HSSFCell cell = row.createCell(startColumn + i);
                    cell.setCellStyle(style);
                    String textValue = aDatalist[i];

                    if (textValue != null) {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(textValue);
                            richString.applyFont(font3);
                            cell.setCellValue(richString);
                        }
                    }
                }
            }
        }

    }

    private void writeVlueToExcelStrings(HSSFWorkbook workbook, HSSFSheet sheet, List<String[]> datalist, int startRow, int startColumn) {
        // 遍历集合数据，产生数据行
        // 外部获得样式后，再进行循环，不要把样式加入循环中
        CellStyle style = createContentStyle(workbook);
        HSSFFont font3 = workbook.createFont();
        font3.setColor(HSSFColor.BLUE.index);

        int index = startRow;
        for (String[] aDatalist : datalist) {
            index++;
            HSSFRow row = sheet.createRow(index);
            for (int i = startRow; i < aDatalist.length; i++) {
                HSSFCell cell = row.createCell(startColumn + i);
                cell.setCellStyle(style);
                String textValue = aDatalist[i];

                if (textValue != null) {
                    Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                    Matcher matcher = p.matcher(textValue);
                    if (matcher.matches()) {
                        cell.setCellValue(Double.parseDouble(textValue));
                    } else {
                        HSSFRichTextString richString = new HSSFRichTextString(textValue);
                        richString.applyFont(font3);
                        cell.setCellValue(richString);
                    }
                }
            }
        }
    }

    /**
     * 生成内容样式
     */
    private HSSFCellStyle createContentStyle(HSSFWorkbook workbook) {
        // 生成并设置另一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        // 生成另一个字体
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        // 把字体应用到当前的样式
        style.setFont(font);
        return style;
    }

    /**
     * 生成标题样式
     */
    private HSSFCellStyle createFirstRowTitleStyle(HSSFWorkbook workbook) {
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);
        // 把字体应用到当前的样式
        style.setFont(font);
        return style;
    }

    /**
     * 生成标题样式
     */
    public HSSFCellStyle createTitleStyle(HSSFWorkbook workbook) {
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.VIOLET.index);
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);
        // 把字体应用到当前的样式
        style.setFont(font);
        return style;
    }

    /**
     * 判断是否为空行
     *
     * @param row 行对象
     */
    private boolean isBlankRow(HSSFRow row) {
        if (row == null) {
            return true;
        }
        boolean result = true;
        for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
            HSSFCell cell = row.getCell(i, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
            String value = "";
            if (cell != null) {
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        value = cell.getStringCellValue();
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        value = String.valueOf((int) cell.getNumericCellValue());
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        value = String.valueOf(cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_FORMULA:
                        value = String.valueOf(cell.getCellFormula());
                        break;
                    default:
                        break;
                }
                if (!value.trim().equals("")) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }




    /**
     * 数据导出
     *
     * @param datas    标题栏
     * @param headers  表头
     * @param response HttpServletResponse
     */
    public static void exportData(List datas, String[] headers,String excelName, HttpServletResponse response) {
        try {
            OutputStream os = response.getOutputStream();
            ExportExcel exportExcel = new ExportExcel();
            HSSFWorkbook workbook;
            if (headers != null) {
                workbook = exportExcel.exportExcel(headers, datas);
            } else {
                workbook = exportExcel.exportExcel(datas);
            }
            response.reset();// 清空输出流   
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            if(StringUtils.isEmpty(excelName)){
                excelName = sdf.format(new Date());
            }

            excelName= URLEncoder.encode(excelName,"UTF-8");
            response.setHeader("Content-disposition","attachment;filename="+excelName+".xls");
            // 生成提示信息，
            response.setContentType("application/vnd.ms-excel");
            workbook.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            logger.info(ExceptionUtils.getMessage(e));        }
    }
}
