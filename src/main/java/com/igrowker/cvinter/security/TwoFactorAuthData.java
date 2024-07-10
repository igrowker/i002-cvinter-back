package com.igrowker.cvinter.security;
import java.util.Date;


public class TwoFactorAuthData {

    private String userId;
    private String twoFactorCode;
    private Date expirationTime;

    public TwoFactorAuthData() {
    }

    public TwoFactorAuthData(String userId, String twoFactorCode, Date expirationTime) {
        this.userId = userId;
        this.twoFactorCode = twoFactorCode;
        this.expirationTime = expirationTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTwoFactorCode() {
        return twoFactorCode;
    }

    public void setTwoFactorCode(String twoFactorCode) {
        this.twoFactorCode = twoFactorCode;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Override
    public String toString() {
        return "TwoFactorAuthenticationData{" +
                "userId='" + userId + '\'' +
                ", twoFactorCode='" + twoFactorCode + '\'' +
                ", expirationTime=" + expirationTime +
                '}';
    }
}

