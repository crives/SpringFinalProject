package com.flatiron.spring.project.SpringFinalProject.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AuthorDTO {
    @NotBlank
    private String name;
}
