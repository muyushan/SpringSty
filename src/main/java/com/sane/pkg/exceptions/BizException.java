package com.sane.pkg.exceptions;

public class BizException extends  Exception {
    private String statusCode;
    private static final String DEFAULT_STATUS_CODE="500";

    public BizException(String message, String statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public BizException(String message) {
        super(message);
        this.statusCode=DEFAULT_STATUS_CODE;

    }
}
