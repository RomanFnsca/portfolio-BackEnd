
package com.PortfolioArgP.PortfolioArgP.Controller;

import com.PortfolioArgP.PortfolioArgP.Dto.DtoEducation;
import com.PortfolioArgP.PortfolioArgP.Entity.Education;
import com.PortfolioArgP.PortfolioArgP.Security.Controller.Message;
import com.PortfolioArgP.PortfolioArgP.Service.SEducation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
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
@RequestMapping("/education")
@CrossOrigin(origins = "http://localhost:4200")
public class EducationController {
    @Autowired
    SEducation sEducation;

    @GetMapping("/list")
    public ResponseEntity<List<Education>> list() {
        List<Education> list = sEducation.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id){
        if(!sEducation.existById(id)){
            return new ResponseEntity(new Message("No existe Id"), HttpStatus.BAD_REQUEST);
        }
        Education education = sEducation.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducation.existById(id)) {
            return new ResponseEntity(new Message("No exite el id indicado"), HttpStatus.NOT_FOUND);
        }
        sEducation.delete(id);
        return new ResponseEntity(new Message("Se eliminó educación"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducation dtoEducation) {
        if (StringUtils.isEmpty(dtoEducation.getNameEducation())) {
            return new ResponseEntity(new Message("El nombre de educación es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (sEducation.existByNameEducation(dtoEducation.getNameEducation())) {
            return new ResponseEntity(new Message("El nombre de educación ya existe"), HttpStatus.BAD_REQUEST);
        }

        Education education = new Education(dtoEducation.getNameEducation(), dtoEducation.getDescriptionEducation());

        sEducation.save(education);
        return new ResponseEntity(new Message("Se creó educación"), HttpStatus.OK);

    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducation dtoEducation) {
        if (!sEducation.existById(id)) {
            return new ResponseEntity(new Message("No exite el Id"), HttpStatus.NOT_FOUND);
        }

        if (sEducation.existByNameEducation(dtoEducation.getNameEducation())
                && sEducation.getByNameEducation(dtoEducation.getNameEducation()).get().getId() != id) {
            return new ResponseEntity(new Message("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isEmpty(dtoEducation.getNameEducation())) {
            return new ResponseEntity(new Message("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        //falta agregar validacion de descripcion
//        if (StringUtils.isEmpty(dtoEducation.getDescriptionEducation())) {
//            return new ResponseEntity(new Message("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
//        }

        //Seteo los cambios
        Education education = sEducation.getOne(id).get();
        education.setNameEducation(dtoEducation.getNameEducation());
        education.setDescriptionEducation(dtoEducation.getDescriptionEducation());

        sEducation.save(education);

        return new ResponseEntity(new Message("Se actualizó educación"), HttpStatus.OK);
    }
}
