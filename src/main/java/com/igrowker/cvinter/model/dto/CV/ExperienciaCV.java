package com.igrowker.cvinter.model.dto.CV;

public class ExperienciaCV {
    private String profesion;
    private String empresa;
    private String dateStart;
    private String dateEnd;
    private String rol;

    public ExperienciaCV() {
    }

    public ExperienciaCV(String profesion, String empresa, String dateStart, String dateEnd, String rol) {
        this.profesion = profesion;
        this.empresa = empresa;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.rol = rol;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "ExperienciaCV{" +
                "profesion='" + profesion + '\'' +
                ", empresa='" + empresa + '\'' +
                ", dateStart='" + dateStart + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
