
package com.PortfolioArgP.PortfolioArgP.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 60, message = "El nombre no es valido")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 60, message = "El Apellido no es valido")
    private String apellido;
    
    @Size(min = 1, max = 60, message = "La imagen no es valida")
    private String perfil;
}
