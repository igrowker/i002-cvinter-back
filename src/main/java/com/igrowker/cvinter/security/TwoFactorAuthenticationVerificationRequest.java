package com.igrowker.cvinter.security;

public class TwoFactorAuthenticationVerificationRequest {

    private String userId;
    private String code;

    public TwoFactorAuthenticationVerificationRequest(String userId, String code) {
        this.userId = userId;
        this.code = code;
    }

    // Getters and setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}