package com.flatiron.spring.project.SpringFinalProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

// Gets the given user's reading list with the ID list_id
// GET /api/users/{id}/reading_lists/{list_id}
@Data
public class ReadingListByIdDTO {
    @JsonProperty("reading_list_id")
    @Positive
    @NotNull
    private Long id;
    @JsonProperty("reading_list_name")
    private String name;
    private List<BookDTO> books;

}
