package com.flatiron.spring.project.SpringFinalProject.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReadingListDTO {

    private String name;
    private List<BookDTO> books;
}
