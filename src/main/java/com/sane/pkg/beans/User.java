package com.sane.pkg.beans;

import java.util.Date;

public class User {
    private int id;
    private String emailPhone;
    private String password;
    private String confirmPassword;
    private String verificationCode;
    private int statusCode;
    private Date verificationLimitDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailPhone() {
        return emailPhone;
    }

    public void setEmailPhone(String emailPhone) {
        this.emailPhone = emailPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Date getVerificationLimitDate() {
        return verificationLimitDate;
    }

    public void setVerificationLimitDate(Date verificationLimitDate) {
        this.verificationLimitDate = verificationLimitDate;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return emailPhone+"==="+password+"===="+statusCode;
    }
}
