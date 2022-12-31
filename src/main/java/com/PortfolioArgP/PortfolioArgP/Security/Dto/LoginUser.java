package com.PortfolioArgP.PortfolioArgP.Security.Dto;

import javax.validation.constraints.NotBlank;

public class LoginUser {

    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    //@Getters
    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //Setters
    public void setPassword(String password) {
        this.password = password;
    }

}
