package com.igrowker.cvinter.security;


public class TwoFactorAuthenticationRequest {

    private String userId;
    private String secretKey;

    public TwoFactorAuthenticationRequest(String userId, String secretKey) {
        this.userId = userId;
        this.secretKey = secretKey;
    }

    // Getters and setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
