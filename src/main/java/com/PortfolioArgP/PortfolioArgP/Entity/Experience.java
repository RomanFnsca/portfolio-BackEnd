package com.PortfolioArgP.PortfolioArgP.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nameExperience;
    private String descriptionExperience;
    
    //Constructores

    public Experience() {
    }

    public Experience(String nameExperience, String descriptionExperience) {
        this.nameExperience = nameExperience;
        this.descriptionExperience = descriptionExperience;
    }
    
    //Getters

    public int getId() {
        return id;
    }

    public String getNameExperience() {
        return nameExperience;
    }

    public String getDescriptionExperience() {
        return descriptionExperience;
    }
    
    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNameExperience(String nameExperience) {
        this.nameExperience = nameExperience;
    }

    public void setDescriptionExperience(String descriptionExperience) {
        this.descriptionExperience = descriptionExperience;
    }
    
}
