package com.flatiron.spring.project.SpringFinalProject.service;

import com.flatiron.spring.project.SpringFinalProject.dto.BookDTO;
import com.flatiron.spring.project.SpringFinalProject.dto.BookSearchResultDTO;
import com.flatiron.spring.project.SpringFinalProject.dto.CreateBookDTO;
import com.flatiron.spring.project.SpringFinalProject.exception.NotFoundException;
import com.flatiron.spring.project.SpringFinalProject.model.Book;
import com.flatiron.spring.project.SpringFinalProject.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private ModelMapper mapper;

    public BookSearchResultDTO create(CreateBookDTO createBookDTO) {
        Book book = mapper.map(createBookDTO, Book.class);
        return mapper.map(repository.save(book), BookSearchResultDTO.class);
    }

    public List<BookDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(book -> mapper.map(book, BookDTO.class))
                .toList();
    }

    public Optional<Book> getBookById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Book not found");
        }
    }

//    public List<BookDTO> getBooksByGenreId(Long genreId) {
//        List<Book> booksByGenreId = repository.getAllByGenreId(genreId);
//        return booksByGenreId.stream()
//                .map(book -> mapper.map(book, BookDTO.class))
//                .toList();
//    }
}
