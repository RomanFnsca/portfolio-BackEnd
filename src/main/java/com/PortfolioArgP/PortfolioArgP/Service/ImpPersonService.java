package com.PortfolioArgP.PortfolioArgP.Service;

import com.PortfolioArgP.PortfolioArgP.Entity.Person;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.PortfolioArgP.PortfolioArgP.Repository.IPersonRepository;
import java.util.Optional;

@Service
@Transactional
public class ImpPersonService {

    @Autowired
    IPersonRepository iPersonRepository;
    
     public List<Person> list() {
        return iPersonRepository.findAll();
    }

    public Optional<Person> getOne(int id) {
        return iPersonRepository.findById(id);
    }

    public Optional<Person> getByName(String name) {
        return iPersonRepository.findByName(name);
    }
    
    public void save(Person person){
        iPersonRepository.save(person);
    }
    
    public void delete(int id){
        iPersonRepository.deleteById(id);
    }
    
    public boolean existById(int id){
        return iPersonRepository.existsById(id);
    }
    
    public boolean existByName(String name){
        return iPersonRepository.existsByName(name);
    }
}
