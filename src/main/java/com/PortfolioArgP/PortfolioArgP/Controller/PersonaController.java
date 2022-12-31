package com.PortfolioArgP.PortfolioArgP.Controller;

import com.PortfolioArgP.PortfolioArgP.Entity.Persona;
import com.PortfolioArgP.PortfolioArgP.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    IPersonaService iPersonaService;

    //Devuelve lista de personas
    @GetMapping("personas/traer")
    public List<Persona> getPersonas() {
        return iPersonaService.getPersona();
    }

    //Crea un objeto de tipo Persona
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        iPersonaService.savePersona(persona);
        return "la persona fué creada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    //Borra un objeto de tipo Persona por id 
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersonas(@PathVariable Long id) {
        iPersonaService.deletePersona(id);
        return "Se borró persona correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    //Editar un objeto de tipo Persona por id 
    @PutMapping("/personas/editar/{id}")
    public String editPersonas(@PathVariable Long id,
            @RequestParam() String newNombre,
            @RequestParam() String newApellido,
            @RequestParam() String newPerfil) {
        Persona persona = iPersonaService.findPersona(id);
        persona.setNombre(newNombre);
        persona.setApellido(newApellido);
        persona.setPerfil(newPerfil);

        iPersonaService.savePersona(persona);
        return "Se modificó persona correctamente";
    }

    //Traer objeto de tipo Persona
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona() {
        return iPersonaService.findPersona((long) 1);
    }
}
