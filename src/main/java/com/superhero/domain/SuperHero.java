package com.superhero.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public class SuperHero {

    @Id
    private String id;
    private String name;
    private String pseudonym;
    private String publisher;
    private List<Skill> skills;
    private List<Ally> allies;
    private Date dateFirstAppearance;

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

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Ally> getAllies() {
        return allies;
    }

    public void setAllies(List<Ally> allies) {
        this.allies = allies;
    }

    public Date getDateFirstAppearance() {
        return dateFirstAppearance;
    }

    public void setDateFirstAppearance(Date dateFirstAppearance) {
        this.dateFirstAppearance = dateFirstAppearance;
    }
}
