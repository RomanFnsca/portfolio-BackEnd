package com.PortfolioArgP.PortfolioArgP.Service;

import com.PortfolioArgP.PortfolioArgP.Entity.Persona;
import com.PortfolioArgP.PortfolioArgP.Interface.IPersonaService;
import com.PortfolioArgP.PortfolioArgP.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService {

    @Autowired
    IPersonaRepository iPersonaRepository;

    //Traigo lista de Personas a traves de Instancia de IPersonaRepository
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = iPersonaRepository.findAll();
        return persona;
    }

    //Guardo Persona
    @Override
    public void savePersona(Persona persona) {
        iPersonaRepository.save(persona);
    }

    //Borro objeto tipo Persona por id
    @Override
    public void deletePersona(Long id) {
        iPersonaRepository.deleteById(id);
    }

    //Búsco objeto tipo Persona por id
    @Override
    public Persona findPersona(Long id) {
        Persona persona = iPersonaRepository.findById(id).orElse(null);
        return persona;
    }

}
