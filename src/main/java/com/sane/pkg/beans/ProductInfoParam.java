package com.sane.pkg.beans;

public class ProductInfoParam extends ProductInfo {
    private int page;
    private int limit;
    private boolean needPager;

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
}