package com.igrowker.cvinter.model.dto.CV;

public class UbicacionCV {
    private String red;
    private String user;

    public UbicacionCV(String red, String user) {
        this.red = red;
        this.user = user;
    }

    public String getRed() {
        return red;
    }

    public String getUser() {
        return user;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UbicacionCV{" +
                "red='" + red + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
