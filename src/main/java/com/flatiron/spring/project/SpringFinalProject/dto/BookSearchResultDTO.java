package com.flatiron.spring.project.SpringFinalProject.dto;

import com.flatiron.spring.project.SpringFinalProject.model.Author;
import com.flatiron.spring.project.SpringFinalProject.model.Genre;

import java.time.LocalDateTime;
import java.util.List;

// Gets a single book with the given ID
// GET /api/books/{id}
public class BookSearchResultDTO {
    private Long id;
    private String title;
    private int pages;
    private LocalDateTime published;
    private AuthorDTO author;
    private List<GenreDTO> genres;
}
