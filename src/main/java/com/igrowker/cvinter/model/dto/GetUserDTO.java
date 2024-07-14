package com.igrowker.cvinter.model.dto;

public class GetUserDTO {
    private String id;
    private String email;
    private String fullname;
    private String role;
    private String updatedAt;
    private String createdAt;
    private CVDTO cv;
    private boolean twoFactorEnabled;

    public GetUserDTO(String id, String email, String fullname, String role, String updatedAt, String createdAt, CVDTO cv, boolean twoFactorEnabled) {
        this.id = id;
        this.email = email;
        this.fullname = fullname;
        this.role = role;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.cv = cv;
        this.twoFactorEnabled = twoFactorEnabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public CVDTO getCv() {
        return cv;
    }

    public void setCv(CVDTO cv) {
        this.cv = cv;
    }

    public boolean isTwoFactorEnabled() {
        return twoFactorEnabled;
    }

    public void setTwoFactorEnabled(boolean twoFactorEnabled) {
        this.twoFactorEnabled = twoFactorEnabled;
    }

    @Override
    public String toString() {
        return "GetUserDTO{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                ", role='" + role + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", cv=" + cv +
                ", twoFactorEnabled=" + twoFactorEnabled +
                '}';
    }
}
