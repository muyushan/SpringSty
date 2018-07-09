package com.sane.pkg.beans.commons;

public class MsgBean {
    public static  String SUCCESS="200";
    public static  String FAIL="500";
    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
