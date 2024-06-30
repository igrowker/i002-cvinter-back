package com.igrowker.cvinter.model.dto;

import com.igrowker.cvinter.model.entity.User;

public class RegisterUserDTO {

    private String email;
    private String password;
    private String FullName;

    public RegisterUserDTO(User user) {
        email = user.getEmail();
        password = user.getPassword();
        FullName = user.getFullName();
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
}
