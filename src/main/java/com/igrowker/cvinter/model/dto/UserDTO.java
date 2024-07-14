package com.igrowker.cvinter.model.dto;

import com.igrowker.cvinter.model.entity.Role;
import com.igrowker.cvinter.model.entity.User;

import java.time.LocalDateTime;

public class UserDTO {

    private String id;
    private String email;
    private String password;
    private String fullName;
    private CVDTO cv;
    private boolean twoFactorEnabled;
    private String twoFactorSecret;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Role role;

    public UserDTO(User user) {
        id = user.getId();
        email = user.getEmail();
        password = user.getPassword();
        fullName = user.getFullName();
        cv = user.getCv().toCVDTO();
        twoFactorEnabled = user.isTwoFactorEnabled();
        twoFactorSecret = user.getTwoFactorSecret();
        createdAt = user.getCreatedAt();
        updatedAt = user.getUpdatedAt();
    }

    public UserDTO(String id, String email, String password, String fullName, CVDTO cv, boolean twoFactorEnabled, String twoFactorSecret, LocalDateTime createdAt, LocalDateTime updatedAt, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.cv = cv;
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
        return fullName;
    }

    public CVDTO getCv() {
        return cv;
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
        this.fullName = fullName;
    }

    public void setCv(CVDTO cvUrl) {
        this.cv = cvUrl;
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
                ", FullName='" + fullName + '\'' +
                ", cvUrl='" + cv + '\'' +
                ", twoFactorEnabled=" + twoFactorEnabled +
                ", twoFactorSecret='" + twoFactorSecret + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", role=" + role +
                '}';
    }

    public GetUserDTO toGetUserDTO() {
        return new GetUserDTO(id, email, fullName, role.toString(), updatedAt.toString(), createdAt.toString(), cv, twoFactorEnabled);
    }
}
