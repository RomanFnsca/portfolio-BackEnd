package com.PortfolioArgP.PortfolioArgP.Security.Repository;

import com.PortfolioArgP.PortfolioArgP.Entity.Person;
import com.PortfolioArgP.PortfolioArgP.Security.Entity.Rol;
import com.PortfolioArgP.PortfolioArgP.Security.Enums.RolName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRolName(RolName rolName);
}
