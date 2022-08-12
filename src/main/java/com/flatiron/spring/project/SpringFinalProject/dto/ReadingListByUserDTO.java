package com.flatiron.spring.project.SpringFinalProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

// Gets the given user's reading lists
// GET /api/users/{id}/reading_lists
@Data
public class ReadingListByUserDTO {
    @JsonProperty("user_id")
    @Positive
    @NotNull
    private Long id;
    @JsonProperty("reading_list_id")
    @Positive
    @NotNull
    private Long readingListId;

    // TODO
    private List<ReadingListDTO> readingList;

}
