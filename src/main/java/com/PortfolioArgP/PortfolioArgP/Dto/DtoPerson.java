package com.PortfolioArgP.PortfolioArgP.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DtoPerson {
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private String description;
    @NotBlank
    private String perfil;

    public DtoPerson() {
    }

    public DtoPerson(String name, String lastName, String description, String perfil) {
        this.name = name;
        this.lastName = lastName;
        this.description = description;
        this.perfil = perfil;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDescription() {
        return description;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    
    
    
}
