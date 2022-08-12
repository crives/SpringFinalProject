package com.flatiron.spring.project.SpringFinalProject.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

// Create a book
// POST /api/books
@Data
public class CreateBookDTO {

    @NotBlank
    private String title;
    private int pages;
    private Date published;
    private String author;
    private List<GenreDTO> genres;
}
