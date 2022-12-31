package com.PortfolioArgP.PortfolioArgP.Security.Dto;

import java.util.HashSet;
import java.util.Set;

public class NewUser {

    private String name;
    private String username;
    private String email;
    private String password;
    private Set<String> roles = new HashSet<>();
    
    //Getters
    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getRoles() {
        return roles;
    }
    
    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
    
    
}
