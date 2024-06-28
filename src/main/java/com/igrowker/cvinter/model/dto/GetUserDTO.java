package com.igrowker.cvinter.model.dto;

public class GetUserDTO {
    private String email;

    public GetUserDTO() {
    }

    public GetUserDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "GetUserDTO{" +
                "email='" + email + '\'' +
                '}';
    }
}
