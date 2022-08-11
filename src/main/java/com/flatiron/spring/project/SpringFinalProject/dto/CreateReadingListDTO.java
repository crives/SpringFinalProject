package com.flatiron.spring.project.SpringFinalProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flatiron.spring.project.SpringFinalProject.model.Book;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

// Create a new reading list for the user with the given ID
// POST /api/users/{id}/reading_lists
@Data
public class CreateReadingListDTO {
    @JsonProperty("user_id")
    private Long userId;

    @NotBlank
    private String name;

    private List<Book> books;
}
