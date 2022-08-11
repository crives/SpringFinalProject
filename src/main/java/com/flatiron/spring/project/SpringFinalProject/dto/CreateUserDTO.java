package com.flatiron.spring.project.SpringFinalProject.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

// Create a user
// POST api/users
@Data
public class CreateUserDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
