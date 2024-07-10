package com.igrowker.cvinter.model.dto.CV;

public class TechSkillCV {
    private String skill;
    private String nivel;

    public TechSkillCV(String skill, String nivel) {
        this.skill = skill;
        this.nivel = nivel;
    }

    public TechSkillCV() {
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "TechSkillCV{" +
                "skill='" + skill + '\'' +
                ", nivel='" + nivel + '\'' +
                '}';
    }
}
