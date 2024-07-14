package com.igrowker.cvinter.model.dto;

import com.igrowker.cvinter.model.dto.CV.*;
import com.igrowker.cvinter.model.entity.CV;

import java.util.ArrayList;

public class CVDTO {

    private String userId;
    private ArrayList<IdiomaCV> idiomas;
    private ArrayList<TechSkillCV> techSkills;
    private ArrayList<ExperienciaCV> experiencia;
    private ArrayList<EducacionCV> education;
    private ArrayList<CertificadoCV> certificados;
    private ArrayList<RedCV> redes;
    private ArrayList<PersonalInfoCV> personalInfo;
    private ArrayList<String> softSkills;

    public CVDTO(String userId, ArrayList<IdiomaCV> idiomas, ArrayList<TechSkillCV> techSkills, ArrayList<ExperienciaCV> experiencia, ArrayList<EducacionCV> education, ArrayList<CertificadoCV> certificados, ArrayList<RedCV> redes, ArrayList<PersonalInfoCV> personalInfo, ArrayList<String> softSkills) {
        this.userId = userId;
        this.idiomas = idiomas;
        this.techSkills = techSkills;
        this.experiencia = experiencia;
        this.education = education;
        this.certificados = certificados;
        this.redes = redes;
        this.personalInfo = personalInfo;
        this.softSkills = softSkills;
    }

    public CVDTO() {
    }

    public CVDTO(ArrayList<IdiomaCV> idiomas, ArrayList<TechSkillCV> techSkills, ArrayList<ExperienciaCV> experiencia, ArrayList<EducacionCV> education, ArrayList<CertificadoCV> certificados, ArrayList<RedCV> redes, ArrayList<PersonalInfoCV> personalInfo, ArrayList<String> softSkills) {
        this.idiomas = idiomas;
        this.techSkills = techSkills;
        this.experiencia = experiencia;
        this.education = education;
        this.certificados = certificados;
        this.redes = redes;
        this.personalInfo = personalInfo;
        this.softSkills = softSkills;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ArrayList<IdiomaCV> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(ArrayList<IdiomaCV> idiomas) {
        this.idiomas = idiomas;
    }

    public ArrayList<TechSkillCV> getTechSkills() {
        return techSkills;
    }

    public void setTechSkills(ArrayList<TechSkillCV> techSkills) {
        this.techSkills = techSkills;
    }

    public ArrayList<ExperienciaCV> getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(ArrayList<ExperienciaCV> experiencia) {
        this.experiencia = experiencia;
    }

    public ArrayList<EducacionCV> getEducation() {
        return education;
    }

    public void setEducation(ArrayList<EducacionCV> education) {
        this.education = education;
    }

    public ArrayList<CertificadoCV> getCertificados() {
        return certificados;
    }

    public void setCertificados(ArrayList<CertificadoCV> certificados) {
        this.certificados = certificados;
    }

    public ArrayList<RedCV> getRedes() {
        return redes;
    }

    public void setRedes(ArrayList<RedCV> redes) {
        this.redes = redes;
    }

    public ArrayList<PersonalInfoCV> getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(ArrayList<PersonalInfoCV> personalInfo) {
        this.personalInfo = personalInfo;
    }

    public ArrayList<String> getSoftSkills() {
        return softSkills;
    }

    public void setSoftSkills(ArrayList<String> softSkills) {
        this.softSkills = softSkills;
    }

    @Override
    public String toString() {
        return "CVDTO{" +
                "userId='" + userId + '\'' +
                ", idiomas=" + idiomas +
                ", techSkills=" + techSkills +
                ", experiencia=" + experiencia +
                ", education=" + education +
                ", certificados=" + certificados +
                ", redes=" + redes +
                ", personalInfo=" + personalInfo +
                ", softSkills=" + softSkills +
                '}';
    }

    public CV toEntity() {
        return new CV(idiomas, techSkills, experiencia, education, certificados, redes, personalInfo, softSkills);
    }
}
