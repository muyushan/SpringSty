package com.sane.pkg.beans;

import java.util.Date;

public class UserInfo {
    private Integer id;

    private String emailPhone;

    private String password;

    private String verificationcode;

    private Integer statuscode;

    private Date verificationlimitdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailPhone() {
        return emailPhone;
    }

    public void setEmailPhone(String emailPhone) {
        this.emailPhone = emailPhone == null ? null : emailPhone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getVerificationcode() {
        return verificationcode;
    }

    public void setVerificationcode(String verificationcode) {
        this.verificationcode = verificationcode == null ? null : verificationcode.trim();
    }

    public Integer getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(Integer statuscode) {
        this.statuscode = statuscode;
    }

    public Date getVerificationlimitdate() {
        return verificationlimitdate;
    }

    public void setVerificationlimitdate(Date verificationlimitdate) {
        this.verificationlimitdate = verificationlimitdate;
    }
}