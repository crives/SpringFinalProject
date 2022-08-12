package com.flatiron.spring.project.SpringFinalProject.controller;

import com.flatiron.spring.project.SpringFinalProject.dto.BookSearchResultDTO;
import com.flatiron.spring.project.SpringFinalProject.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreController {

    @Autowired
    private GenreService service;

    @GetMapping("/{id}/books")
    public List<BookSearchResultDTO> getBooksById(@PathVariable Long id) {
        return service.getBooksByGenreId(id);
    }
}
