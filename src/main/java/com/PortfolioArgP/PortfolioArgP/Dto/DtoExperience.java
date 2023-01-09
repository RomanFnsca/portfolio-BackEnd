
package com.PortfolioArgP.PortfolioArgP.Dto;

import javax.validation.constraints.NotBlank;


public class DtoExperience {
    @NotBlank
    private String nameExperience;
    @NotBlank
    private String descriptionExperience;

    //Constructores

    public DtoExperience() {
    }

    public DtoExperience(String nameExperience, String descriptionExperience) {
        this.nameExperience = nameExperience;
        this.descriptionExperience = descriptionExperience;
    }
    
    //Getters

    public String getNameExperience() {
        return nameExperience;
    }

    public String getDescriptionExperience() {
        return descriptionExperience;
    }
    
    //Setters

    public void setNameExperience(String nameExperience) {
        this.nameExperience = nameExperience;
    }

    public void setDescriptionExperience(String descriptionExperience) {
        this.descriptionExperience = descriptionExperience;
    }
    
}
