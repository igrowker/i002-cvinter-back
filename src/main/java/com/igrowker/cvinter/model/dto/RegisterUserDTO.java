package com.igrowker.cvinter.model.dto;

import com.igrowker.cvinter.model.entity.User;

public class RegisterUserDTO {

    private String email;
    private String password;
    private String fullName;

    public RegisterUserDTO(User user) {
        email = user.getEmail();
        password = user.getPassword();
        fullName = user.getFullName();
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

    public RegisterUserDTO(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public RegisterUserDTO() {
    }

    @Override
    public String toString() {
        return "RegisterUserDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
