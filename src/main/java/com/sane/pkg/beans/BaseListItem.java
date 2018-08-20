package com.sane.pkg.beans;

import java.util.Date;

public class BaseListItem {
    private Integer listID;

    private Short typeID;

    private String listValue;

    private String listName;

    private Short listSort;

    private String creator;

    private Date creatDate;

    private String modifier;

    private Date modifyDate;

    public Integer getListID() {
        return listID;
    }

    public void setListID(Integer listID) {
        this.listID = listID;
    }

    public Short getTypeID() {
        return typeID;
    }

    public void setTypeID(Short typeID) {
        this.typeID = typeID;
    }

    public String getListValue() {
        return listValue;
    }

    public void setListValue(String listValue) {
        this.listValue = listValue == null ? null : listValue.trim();
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName == null ? null : listName.trim();
    }

    public Short getListSort() {
        return listSort;
    }

    public void setListSort(Short listSort) {
        this.listSort = listSort;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}