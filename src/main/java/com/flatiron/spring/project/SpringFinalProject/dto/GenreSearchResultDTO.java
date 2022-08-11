package com.flatiron.spring.project.SpringFinalProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flatiron.spring.project.SpringFinalProject.model.Book;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

// Get all books in the genre with the given ID
// GET /api/genre/{id}/books
@Data
public class GenreSearchResultDTO {

    @JsonProperty("genre_id")
    @Positive
    @NotNull
    private Long id;
    @JsonProperty("genre_name")
    private String name;
    private List<BookDTO> books;
}
