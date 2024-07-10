package com.igrowker.cvinter.model.dto.CV;

public class RedCV {
    private String red;
    private String user;

    public RedCV(String red, String user) {
        this.red = red;
        this.user = user;
    }

    public RedCV() {
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "RedCV{" +
                "red='" + red + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
