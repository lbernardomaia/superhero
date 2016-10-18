package com.superhero.dto;

import java.util.List;

public class SuperHeroDTO {
    private String id;
    private String name;
    private String pseudonym;
    private String publisher;
    private List<SkillDTO> skillsDTO;
    private List<AllyDTO> alliesDTO;
    private String dateFirstAppearance;

    public SuperHeroDTO(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<SkillDTO> getSkillsDTO() {
        return skillsDTO;
    }

    public void setSkillsDTO(List<SkillDTO> skillsDTO) {
        this.skillsDTO = skillsDTO;
    }

    public List<AllyDTO> getAlliesDTO() {
        return alliesDTO;
    }

    public void setAlliesDTO(List<AllyDTO> alliesDTO) {
        this.alliesDTO = alliesDTO;
    }

    public String getDateFirstAppearance() {
        return dateFirstAppearance;
    }

    public void setDateFirstAppearance(String dateFirstAppearance) {
        this.dateFirstAppearance = dateFirstAppearance;
    }
}
