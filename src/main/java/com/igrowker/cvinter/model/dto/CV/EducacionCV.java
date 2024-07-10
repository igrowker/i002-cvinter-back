package com.igrowker.cvinter.model.dto.CV;

public class EducacionCV {
    private String institucion;
    private String carrera;
    private String nivel;
    private int anoStart;
    private int anoEnd;

    public EducacionCV() {
    }

    public EducacionCV(String institucion, String carrera, String nivel, int anoStart, int anoEnd) {
        this.institucion = institucion;
        this.carrera = carrera;
        this.nivel = nivel;
        this.anoStart = anoStart;
        this.anoEnd = anoEnd;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getAnoStart() {
        return anoStart;
    }

    public void setAnoStart(int anoStart) {
        this.anoStart = anoStart;
    }

    public int getAnoEnd() {
        return anoEnd;
    }

    public void setAnoEnd(int anoEnd) {
        this.anoEnd = anoEnd;
    }

    @Override
    public String toString() {
        return "EducacionCV{" +
                "institucion='" + institucion + '\'' +
                ", carrera='" + carrera + '\'' +
                ", nivel='" + nivel + '\'' +
                ", anoStart=" + anoStart +
                ", anoEnd=" + anoEnd +
                '}';
    }
}
