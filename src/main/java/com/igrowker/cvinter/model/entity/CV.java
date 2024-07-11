package com.igrowker.cvinter.model.entity;

import com.igrowker.cvinter.model.dto.CV.*;
import com.igrowker.cvinter.model.dto.CVDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

public class CV {
    private ArrayList<IdiomaCV> idiomas;
    private ArrayList<TechSkillCV> techSkills;
    private ArrayList<ExperienciaCV> experiencias;
    private ArrayList<EducacionCV> educaciones;
    private ArrayList<CertificadoCV> certificados;
    private ArrayList<RedCV> redes;
    private ArrayList<UbicacionCV> ubicaciones;

    public CV() {
    }

    public CV(ArrayList<IdiomaCV> idiomas, ArrayList<TechSkillCV> techSkills, ArrayList<ExperienciaCV> experiencias, ArrayList<EducacionCV> educaciones, ArrayList<CertificadoCV> certificados, ArrayList<RedCV> redes, ArrayList<UbicacionCV> ubicaciones) {
        this.idiomas = idiomas;
        this.techSkills = techSkills;
        this.experiencias = experiencias;
        this.educaciones = educaciones;
        this.certificados = certificados;
        this.redes = redes;
        this.ubicaciones = ubicaciones;
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

    public ArrayList<ExperienciaCV> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(ArrayList<ExperienciaCV> experiencias) {
        this.experiencias = experiencias;
    }

    public ArrayList<EducacionCV> getEducaciones() {
        return educaciones;
    }

    public void setEducaciones(ArrayList<EducacionCV> educaciones) {
        this.educaciones = educaciones;
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

    public ArrayList<UbicacionCV> getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(ArrayList<UbicacionCV> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    public CVDTO toCVDTO() {
        return new CVDTO(idiomas, techSkills, experiencias, educaciones, certificados, redes, ubicaciones);
    }
}
