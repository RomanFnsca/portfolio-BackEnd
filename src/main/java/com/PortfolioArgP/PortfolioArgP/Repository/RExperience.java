package com.PortfolioArgP.PortfolioArgP.Repository;

import com.PortfolioArgP.PortfolioArgP.Entity.Experience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RExperience extends JpaRepository<Experience,Integer>{
    public Optional<Experience>findByNameExperience(String nameExperience);
    public boolean existsByNameExperience(String nameExperience);  
}
