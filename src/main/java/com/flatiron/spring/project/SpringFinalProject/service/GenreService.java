package com.flatiron.spring.project.SpringFinalProject.service;

import com.flatiron.spring.project.SpringFinalProject.dto.BookSearchResultDTO;
import com.flatiron.spring.project.SpringFinalProject.exception.NotFoundException;
import com.flatiron.spring.project.SpringFinalProject.model.Book;
import com.flatiron.spring.project.SpringFinalProject.model.Genre;
import com.flatiron.spring.project.SpringFinalProject.repository.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository repository;

    @Autowired
    private ModelMapper mapper;
    public List<BookSearchResultDTO> getBooksByGenreId(Long id) {
        Genre genre = repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Genre not found"));
        List<Book> booksInGenre = genre.getBooks();
        return booksInGenre.stream()
                .map(book -> mapper.map(book, BookSearchResultDTO.class))
                .toList();
    }
}
