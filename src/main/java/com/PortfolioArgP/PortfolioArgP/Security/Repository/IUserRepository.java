package com.PortfolioArgP.PortfolioArgP.Security.Repository;

import com.PortfolioArgP.PortfolioArgP.Security.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
    
    //Solucionados
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

   
}
