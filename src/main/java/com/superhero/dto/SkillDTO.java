package com.superhero.dto;

public class SkillDTO {

    private String name;

    public SkillDTO(){}

    public SkillDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
