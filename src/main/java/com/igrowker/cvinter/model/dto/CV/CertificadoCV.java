package com.igrowker.cvinter.model.dto.CV;

public class CertificadoCV {
    private String skill;
    private String entidadEmisora;
    private int ano;

    public CertificadoCV(String skill, String entidadEmisora, int ano) {
        this.skill = skill;
        this.entidadEmisora = entidadEmisora;
        this.ano = ano;
    }

    public CertificadoCV() {
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getEntidadEmisora() {
        return entidadEmisora;
    }

    public void setEntidadEmisora(String entidadEmisora) {
        this.entidadEmisora = entidadEmisora;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "CertificadoCV{" +
                "skill='" + skill + '\'' +
                ", entidadEmisora='" + entidadEmisora + '\'' +
                ", ano=" + ano +
                '}';
    }
}
