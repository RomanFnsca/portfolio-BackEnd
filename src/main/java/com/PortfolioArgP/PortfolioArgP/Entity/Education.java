
package com.PortfolioArgP.PortfolioArgP.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameEducation;
    private String descriptionEducation;
    
    //Constructores
    public Education() {
    }

    public Education(String nameEducation, String descriptionEducation) {
        this.nameEducation = nameEducation;
        this.descriptionEducation = descriptionEducation;
    }
    
    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameEducation() {
        return nameEducation;
    }

    public void setNameEducation(String nameEducation) {
        this.nameEducation = nameEducation;
    }

    public String getDescriptionEducation() {
        return descriptionEducation;
    }

    public void setDescriptionEducation(String descriptionEducation) {
        this.descriptionEducation = descriptionEducation;
    }

}
