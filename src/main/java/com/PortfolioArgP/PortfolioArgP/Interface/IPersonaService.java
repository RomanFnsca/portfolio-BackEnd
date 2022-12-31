package com.PortfolioArgP.PortfolioArgP.Interface;

import com.PortfolioArgP.PortfolioArgP.Entity.Persona;
import java.util.List;

public interface IPersonaService {
//Traer objeto tipo Persona
    public List<Persona> getPersona();
    
    //Guardar objeto persona
    public void savePersona(Persona persona);
    
    //Eliminar persona por id
    public void deletePersona(Long id);
    
    //Busca Persona por id
    public Persona findPersona(Long id);
}
