
package com.PortfolioArgP.PortfolioArgP.Dto;

import javax.validation.constraints.NotBlank;

public class DtoEducation {
    @NotBlank
    private String nameEducation;
    @NotBlank
    private String descriptionEducation;

    //Constructores
    public DtoEducation() {
    }

    public DtoEducation(String nameEducation, String descriptionEducation) {
        this.nameEducation = nameEducation;
        this.descriptionEducation = descriptionEducation;
    }
    
    //Getters
    public String getNameEducation() {
        return nameEducation;
    }

    public String getDescriptionEducation() {
        return descriptionEducation;
    }
    
    //Setters

    public void setNameEducation(String nameEducation) {
        this.nameEducation = nameEducation;
    }

    public void setDescriptionEducation(String descriptionEducation) {
        this.descriptionEducation = descriptionEducation;
    }
}
