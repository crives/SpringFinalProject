package com.flatiron.spring.project.SpringFinalProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flatiron.spring.project.SpringFinalProject.model.Book;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

// Create a new reading list for the user with the given ID
// POST /api/users/{id}/reading_lists
// list/{id}/book/{id}
@Data
public class CreateReadingListDTO {

    @NotBlank
    private String name;
    private List<BookDTO> books;
}
