
package com.PortfolioArgP.PortfolioArgP.Controller;

import com.PortfolioArgP.PortfolioArgP.Dto.DtoExperience;
import com.PortfolioArgP.PortfolioArgP.Entity.Experience;
import com.PortfolioArgP.PortfolioArgP.Security.Controller.Message;
import com.PortfolioArgP.PortfolioArgP.Service.ExperienceService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experience")
@CrossOrigin(origins = "http://localhost:4200") 
public class ExperienceController {
    @Autowired
    ExperienceService experienceService;

    @GetMapping("/list")
    public ResponseEntity<List<Experience>> list() {
        List<Experience> list = experienceService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") int id){
        if(!experienceService.existById(id)){
            return new ResponseEntity(new Message("No existe Id"), HttpStatus.BAD_REQUEST);
        }
        Experience experience = experienceService.getOne(id).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!experienceService.existById(id)) {
            return new ResponseEntity(new Message("No exite el id indicado"), HttpStatus.NOT_FOUND);
        }
        experienceService.delete(id);
        return new ResponseEntity(new Message("Se eliminó experiencia"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperience dtoExperience) {
        
        if (StringUtils.isEmpty(dtoExperience.getNameExperience())) {
            return new ResponseEntity(new Message("El nombre de experiencia es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (experienceService.existByNameExperience(dtoExperience.getNameExperience())) {
            return new ResponseEntity(new Message("El nombre de experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }

        Experience experience = new Experience(dtoExperience.getNameExperience(), dtoExperience.getDescriptionExperience());

        experienceService.save(experience);
        return new ResponseEntity(new Message("Se creó experiencia"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperience dtoExperience) {
        //Validaciones
        if (!experienceService.existById(id)) {
            return new ResponseEntity(new Message("No exite el Id"), HttpStatus.NOT_FOUND);
        }

        if (experienceService.existByNameExperience(dtoExperience.getNameExperience())
                && experienceService.getByNameExperience(dtoExperience.getNameExperience()).get().getId() != id) {
            return new ResponseEntity(new Message("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isEmpty(dtoExperience.getNameExperience())) {
            return new ResponseEntity(new Message("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        //Seteo los cambios
        Experience experience = experienceService.getOne(id).get();
        experience.setNameExperience(dtoExperience.getNameExperience());
        experience.setDescriptionExperience(dtoExperience.getDescriptionExperience());

        experienceService.save(experience);

        return new ResponseEntity(new Message("Se actualizó experiencia"), HttpStatus.OK);
    }
}
