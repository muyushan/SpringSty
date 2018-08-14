package com.sane.pkg.exceptions;

public class SessionTimeOutException extends  Exception{
    private static final long serialVersionUID = 1L;
    public static final String ERR_CODE = "201";
    private String errorCode;

    public SessionTimeOutException(String message){
        super(message);
    }
    public SessionTimeOutException(String errorCode,String errorMessage){

    }
    public String getErrorCode() {

        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
