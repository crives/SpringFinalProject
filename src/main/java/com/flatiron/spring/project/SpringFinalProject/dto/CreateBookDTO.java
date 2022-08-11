package com.flatiron.spring.project.SpringFinalProject.dto;

import com.flatiron.spring.project.SpringFinalProject.model.Author;
import com.flatiron.spring.project.SpringFinalProject.model.Genre;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

// Create a book
// POST /api/books
public class CreateBookDTO {

    @NotBlank
    private String title;
    private int pages;
    private LocalDateTime published;
    private Author author;
    private List<GenreDTO> genres;
}
