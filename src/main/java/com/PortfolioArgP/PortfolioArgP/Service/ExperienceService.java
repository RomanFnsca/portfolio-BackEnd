package com.PortfolioArgP.PortfolioArgP.Service;

import com.PortfolioArgP.PortfolioArgP.Entity.Experience;
import com.PortfolioArgP.PortfolioArgP.Repository.RExperience;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienceService {

    @Autowired
    RExperience rExperience;
    
    public List<Experience> list() {
        return rExperience.findAll();
    }

    public Optional<Experience> getOne(int id) {
        return rExperience.findById(id);
    }

    public Optional<Experience> getByNameExperience(String nameExperience) {
        return rExperience.findByNameExperience(nameExperience);
    }
    
    public void save(Experience experience){
        rExperience.save(experience);
    }
    
    public void delete(int id){
        rExperience.deleteById(id);
    }
    
    public boolean existById(int id){
        return rExperience.existsById(id);
    }
    
    public boolean existByNameExperience(String nameExperience){
        return rExperience.existsByNameExperience(nameExperience);
    }
    
}
