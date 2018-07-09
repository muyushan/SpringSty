package com.sane.pkg.beans;

import java.util.Date;

public class BaseListItem {
    private Integer listid;

    private Short typeid;

    private Short listvalue;

    private String listname;

    private Short listsort;

    private String creator;

    private Date creatdate;

    private String modifier;

    private Date modifydate;

    public Integer getListid() {
        return listid;
    }

    public void setListid(Integer listid) {
        this.listid = listid;
    }

    public Short getTypeid() {
        return typeid;
    }

    public void setTypeid(Short typeid) {
        this.typeid = typeid;
    }

    public Short getListvalue() {
        return listvalue;
    }

    public void setListvalue(Short listvalue) {
        this.listvalue = listvalue;
    }

    public String getListname() {
        return listname;
    }

    public void setListname(String listname) {
        this.listname = listname == null ? null : listname.trim();
    }

    public Short getListsort() {
        return listsort;
    }

    public void setListsort(Short listsort) {
        this.listsort = listsort;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Date creatdate) {
        this.creatdate = creatdate;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }
}