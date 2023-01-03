package com.PortfolioArgP.PortfolioArgP.Repository;

import com.PortfolioArgP.PortfolioArgP.Entity.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducation extends JpaRepository<Education, Integer> {
    public Optional<Education>findByNameEducation(String nameEducation);
    public boolean existsByNameEducation(String nameEducation);   
}
