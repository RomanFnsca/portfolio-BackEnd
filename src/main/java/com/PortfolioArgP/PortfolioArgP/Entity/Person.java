
package com.PortfolioArgP.PortfolioArgP.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 60, message = "El nombre no es valido")
    private String name;

    @NotNull
    @Size(min = 1, max = 60, message = "El Apellido no es valido")
    private String lastName;
    
    @NotNull
    @Size(min = 1, max = 500, message = "La descripción no es valida")
    private String description;
    
    private String perfil;

    public Person() {
    }

    public Person(String name, String lastName, String description, String perfil) {
        this.name = name;
        this.lastName = lastName;
        this.description = description;
        this.perfil = perfil;
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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
