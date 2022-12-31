package com.PortfolioArgP.PortfolioArgP.Security.Service;

import com.PortfolioArgP.PortfolioArgP.Security.Entity.User;
import com.PortfolioArgP.PortfolioArgP.Security.Repository.IUserRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    @Autowired
    IUserRepository iUserRepository;
    
    public Optional<User> getByUserName(String userName) {
        return iUserRepository.findByUsername(userName);
    }

    public boolean existByUsername(String userName) {
        return iUserRepository.existsByUsername(userName);
    }

    public boolean existByEmail(String email) {
        return iUserRepository.existsByEmail(email);
    }

    public void save(User user) {
        iUserRepository.save(user);
    }
}
