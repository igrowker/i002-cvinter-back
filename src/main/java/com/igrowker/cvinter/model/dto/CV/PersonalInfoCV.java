package com.igrowker.cvinter.model.dto.CV;

public class PersonalInfoCV {
    private String icon;
    private String dato;

    public PersonalInfoCV(String icon, String dato) {
        this.icon = icon;
        this.dato = dato;
    }

    public PersonalInfoCV() {
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "PersonalInfoCV{" +
                "icon='" + icon + '\'' +
                ", dato='" + dato + '\'' +
                '}';
    }
}
