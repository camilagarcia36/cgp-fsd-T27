package com.ejercicio.dto;

import javax.validation.constraints.NotBlank;

// Login request form
public class LoginRequest {
    
    // Atributos
    
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    // Getters y setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

