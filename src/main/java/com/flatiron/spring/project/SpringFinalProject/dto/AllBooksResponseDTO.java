package com.flatiron.spring.project.SpringFinalProject.dto;

import com.flatiron.spring.project.SpringFinalProject.model.Book;
import lombok.Data;

import java.util.List;

// Gets all the books in the Book table
// GET /api/books
@Data
public class AllBooksResponseDTO {
    List<BookDTO> books;
}
