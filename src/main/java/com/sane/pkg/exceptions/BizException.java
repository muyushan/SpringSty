package com.sane.pkg.exceptions;

public class BizException extends Exception {
    private final  static String defaultStatusCode="500";
    private String statusCode;
    public BizException(String statusCode,String message){
        super(message);
        this.statusCode=statusCode;

    }
    public  BizException(String message){
        super(message);
        this.statusCode=defaultStatusCode;

    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
