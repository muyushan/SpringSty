package com.sane.pkg.beans;

import com.sane.pkg.beans.commons.ExcelField;
import org.springframework.web.bind.annotation.RequestMapping;

public class BaseListItemExcel {
    @ExcelField(displayName = "字典类型",fieldType = ExcelField.FieldType.STRING)
    private String typeName;
    @ExcelField(displayName = "字典项名称",fieldType = ExcelField.FieldType.STRING)
    private String listName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
