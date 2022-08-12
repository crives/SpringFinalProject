package com.flatiron.spring.project.SpringFinalProject.dto;

import com.flatiron.spring.project.SpringFinalProject.model.Genre;
import lombok.Data;

import java.util.Date;
import java.util.List;

// Gets a single book with the given ID
// GET /api/books/{id}
@Data
public class BookSearchResultDTO {
    private Long id;
    private String title;
    private int pages;
    private Date published;
    private AuthorDTO author;
    private List<GenreDTO> genres;
}
