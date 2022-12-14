package com.PortfolioArgP.PortfolioArgP.Security.Service;

import com.PortfolioArgP.PortfolioArgP.Security.Entity.User;
import com.PortfolioArgP.PortfolioArgP.Security.Entity.UserMain;
//import static jdk.internal.util.StaticProperty.userName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService {
    
     @Autowired 
     UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUserName(username).get();
        return UserMain.build(user);
    }

}
