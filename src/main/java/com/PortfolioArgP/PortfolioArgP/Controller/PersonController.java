package com.PortfolioArgP.PortfolioArgP.Controller;

import com.PortfolioArgP.PortfolioArgP.Dto.DtoPerson;
import com.PortfolioArgP.PortfolioArgP.Entity.Person;
import com.PortfolioArgP.PortfolioArgP.Security.Controller.Message;
import com.PortfolioArgP.PortfolioArgP.Service.ImpPersonService;
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
@RequestMapping("/person")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {

    @Autowired
    ImpPersonService personService;

    @GetMapping("/list")
    public ResponseEntity<List<Person>> list() {
        List<Person> list = personService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") int id) {
        if (!personService.existById(id)) {
            return new ResponseEntity(new Message("No existe Id"), HttpStatus.BAD_REQUEST);
        }
        Person person = personService.getOne(id).get();
        return new ResponseEntity(person, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!personService.existById(id)) {
            return new ResponseEntity(new Message("No exite el id indicado"), HttpStatus.NOT_FOUND);
        }
        personService.delete(id);
        return new ResponseEntity(new Message("Se eliminó persona"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoPerson dtoPerson) {

//        if (StringUtils.isEmpty(dtoEducation.getNameEducation())) {
//            return new ResponseEntity(new Message("El nombre de educación es obligatorio"), HttpStatus.BAD_REQUEST);
//        }
//
//        if (sEducation.existByNameEducation(dtoEducation.getNameEducation())) {
//            return new ResponseEntity(new Message("El nombre de educación ya existe"), HttpStatus.BAD_REQUEST);
//        }
        Person person = new Person(dtoPerson.getName(), dtoPerson.getLastName(), dtoPerson.getDescription(), dtoPerson.getPerfil());

        personService.save(person);
        return new ResponseEntity(new Message("Se creó Persona"), HttpStatus.OK);

    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPerson dtoPerson) {
        if (!personService.existById(id)) {
            return new ResponseEntity(new Message("No exite el Id"), HttpStatus.NOT_FOUND);
        }

       if (personService.existByName(dtoPerson.getName())
                && personService.getByName(dtoPerson.getName()).get().getId() != id) {
            return new ResponseEntity(new Message("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isEmpty(dtoPerson.getName())) {
            return new ResponseEntity(new Message("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        //falta agregar validacion de descripcion
//        if (StringUtils.isEmpty(dtoEducation.getDescriptionEducation())) {
//            return new ResponseEntity(new Message("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
//        }

        //Seteo los cambios
        Person person = personService.getOne(id).get();
        person.setName(dtoPerson.getName());
        person.setLastName(dtoPerson.getLastName());
        person.setDescription(dtoPerson.getDescription());
        person.setPerfil(dtoPerson.getPerfil());
        

        personService.save(person);

        return new ResponseEntity(new Message("Se modificó persona"), HttpStatus.OK);
    }

}
