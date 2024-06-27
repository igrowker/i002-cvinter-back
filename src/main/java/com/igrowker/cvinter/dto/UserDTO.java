package com.igrowker.cvinter.dto;

import com.igrowker.cvinter.model.User;

import java.time.LocalDateTime;

public class UserDTO {

    private Long id;
    private String email;
    private String password;
    private String FullName;
    private String cvUrl;
    private boolean twoFactorEnabled;
    private String twoFactorSecret;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserDTO(User user) {
        id = user.getId();
        email = user.getEmail();
        password = user.getPassword();
        FullName = user.getFullName();
        cvUrl = user.getCvUrl();
        twoFactorEnabled = user.isTwoFactorEnabled();
        twoFactorSecret = user.getTwoFactorSecret();
        createdAt = user.getCreatedAt();
        updatedAt = user.getUpdatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return FullName;
    }

    public String getCvUrl() {
        return cvUrl;
    }

    public boolean isTwoFactorEnabled() {
        return twoFactorEnabled;
    }

    public String getTwoFactorSecret() {
        return twoFactorSecret;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
