package com.sane.pkg.beans;

import com.sane.pkg.beans.commons.ExcelField;
import org.springframework.web.bind.annotation.RequestMapping;

public class BaseListItemExcel {
    @ExcelField(displayName = "字典类型",fieldType = ExcelField.FieldType.STRING)
    private String typeName;
    @ExcelField(displayName = "字典项值",fieldType = ExcelField.FieldType.STRING)
    private String listValue;
    @ExcelField(displayName = "字典项名称",fieldType = ExcelField.FieldType.STRING)
    private String listName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getListValue() {
        return listValue;
    }

    public void setListValue(String listValue) {
        this.listValue = listValue;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
