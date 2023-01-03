package com.PortfolioArgP.PortfolioArgP.Service;

import com.PortfolioArgP.PortfolioArgP.Entity.Education;
import com.PortfolioArgP.PortfolioArgP.Repository.REducation;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducation {
@Autowired
    REducation rEducation;

    public List<Education> list() {
        return rEducation.findAll();
    }

    public Optional<Education> getOne(int id) {
        return rEducation.findById(id);
    }

    public Optional<Education> getByNameEducation(String nameEducation) {
        return rEducation.findByNameEducation(nameEducation);
    }
    
    public void save(Education education){
        rEducation.save(education);
    }
    
    public void delete(int id){
        rEducation.deleteById(id);
    }
    
    public boolean existById(int id){
        return rEducation.existsById(id);
    }
    
    public boolean existByNameEducation(String nameEducation){
        return rEducation.existsByNameEducation(nameEducation);
    }
}
