package com.igrowker.cvinter.model.dto.CV;

public class IdiomaCV {
    private String language;
    private String nivel;

    public IdiomaCV(String language, String nivel) {
        this.language = language;
        this.nivel = nivel;
    }

    public IdiomaCV() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "IdiomaCV{" +
                "language='" + language + '\'' +
                ", nivel='" + nivel + '\'' +
                '}';
    }
}
