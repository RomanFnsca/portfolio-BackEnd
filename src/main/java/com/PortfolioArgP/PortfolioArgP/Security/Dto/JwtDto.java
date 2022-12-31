package com.PortfolioArgP.PortfolioArgP.Security.Dto;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

public class JwtDto {

    private String token;
    private String bearer = "Bearer";
    private String username;
    private Collection<? extends GrantedAuthority> authorities;
    
    //Constructor
    public JwtDto(String token, String username, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.username = username;
        this.authorities = authorities;
    }
    
    //Getters
    public String getToken() {
        return token;
    }

    public String getBearer() {
        return bearer;
    }

    public String getUsername() {
        return username;
    }

   
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    
    //@Setters
    public void setToken(String token) {
        this.token = token;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    
}
