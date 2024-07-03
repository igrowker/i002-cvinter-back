package com.igrowker.cvinter.model.dto;

import com.igrowker.cvinter.model.entity.Role;
import com.igrowker.cvinter.model.entity.User;

import java.time.LocalDateTime;

public class UserDTO {

    private String id;
    private String email;
    private String password;
    private String FullName;
    private String cvUrl;
    private boolean twoFactorEnabled;
    private String twoFactorSecret;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Role role;

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

    public UserDTO(String id, String email, String password, String fullName, String cvUrl, boolean twoFactorEnabled, String twoFactorSecret, LocalDateTime createdAt, LocalDateTime updatedAt, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        FullName = fullName;
        this.cvUrl = cvUrl;
        this.twoFactorEnabled = twoFactorEnabled;
        this.twoFactorSecret = twoFactorSecret;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.role = role;
    }

    public UserDTO() {

    }

    public String getId() {
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

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public void setCvUrl(String cvUrl) {
        this.cvUrl = cvUrl;
    }

    public void setTwoFactorEnabled(boolean twoFactorEnabled) {
        this.twoFactorEnabled = twoFactorEnabled;
    }

    public void setTwoFactorSecret(String twoFactorSecret) {
        this.twoFactorSecret = twoFactorSecret;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", FullName='" + FullName + '\'' +
                ", cvUrl='" + cvUrl + '\'' +
                ", twoFactorEnabled=" + twoFactorEnabled +
                ", twoFactorSecret='" + twoFactorSecret + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", role=" + role +
                '}';
    }
}
