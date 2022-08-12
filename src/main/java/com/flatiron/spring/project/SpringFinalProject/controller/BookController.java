package com.flatiron.spring.project.SpringFinalProject.controller;

import com.flatiron.spring.project.SpringFinalProject.dto.BookSearchResultDTO;
import com.flatiron.spring.project.SpringFinalProject.dto.CreateBookDTO;
import com.flatiron.spring.project.SpringFinalProject.model.Book;
import com.flatiron.spring.project.SpringFinalProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/*
GET /api/books	- Gets all the books in the Book table.
GET /api/books/{id} -	Gets a single book with the given ID.
POST /api/books -	Create a book.

PUT /api/books/{id} -	Update a book with the given ID.
DELETE /api/books/{id}	- Delete a book.
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public BookSearchResultDTO createBook(@Valid @RequestBody CreateBookDTO createBookDTO) {
        return service.create(createBookDTO);
    }

    @GetMapping
    public List<BookSearchResultDTO> getAllBooks() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public BookSearchResultDTO getBook(@PathVariable Long id) {
        return service.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.deleteById(id);
    }
}
