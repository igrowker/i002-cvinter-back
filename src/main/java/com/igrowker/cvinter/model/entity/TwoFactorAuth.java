package com.igrowker.cvinter.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "two_factor_auth")

public class TwoFactorAuth {
    @Id
    private String userId;
    private String secretKey;
    private String lastCode;

    public TwoFactorAuth(String userId, String secretKey) {
        this.userId = userId;
        this.secretKey = secretKey;
        this.lastCode = lastCode;
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

    public String getLastCode() {
        return lastCode;
    }

    public void setLastCode(String lastCode) {
        this.lastCode = lastCode;
    }
}

    

