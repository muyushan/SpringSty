package com.sane.pkg.beans;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class ProductInfoParam extends ProductInfo {
    private int page=1;
    private int limit=10;
    private boolean needPager;
    private String keyWord;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date beginDate;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    private List<Integer>idList;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public boolean isNeedPager() {
        return needPager;
    }

    public void setNeedPager(boolean needPager) {
        this.needPager = needPager;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }
}
