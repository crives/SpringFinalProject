package com.flatiron.spring.project.SpringFinalProject.service;

import com.flatiron.spring.project.SpringFinalProject.dto.BookSearchResultDTO;
import com.flatiron.spring.project.SpringFinalProject.dto.CreateBookDTO;
import com.flatiron.spring.project.SpringFinalProject.dto.GenreDTO;
import com.flatiron.spring.project.SpringFinalProject.exception.NotFoundException;
import com.flatiron.spring.project.SpringFinalProject.model.Author;
import com.flatiron.spring.project.SpringFinalProject.model.Book;
import com.flatiron.spring.project.SpringFinalProject.model.Genre;
import com.flatiron.spring.project.SpringFinalProject.repository.AuthorRepository;
import com.flatiron.spring.project.SpringFinalProject.repository.BookRepository;
import com.flatiron.spring.project.SpringFinalProject.repository.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
GET /api/books	- Gets all the books in the Book table.
GET /api/books/{id} -	Gets a single book with the given ID.
POST /api/books -	Create a book.

PUT /api/books/{id} -	Update a book with the given ID.
DELETE /api/books/{id}	- Delete a book.
 */
@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private ModelMapper mapper;

    public BookSearchResultDTO create(CreateBookDTO createBookDTO) {
        // Create author
        Author author = new Author();
        author.setName(createBookDTO.getAuthor());

        List<GenreDTO> genresDTO = createBookDTO.getGenres();
        List<Genre> genres = genresDTO.stream()
                .map(genreDTO -> mapper.map(genreDTO, Genre.class))
                .collect(Collectors.toList());

        Book book = mapper.map(createBookDTO, Book.class);
        book.setAuthor(author);
        book.setGenres(genres);

        authorRepository.save(author);
        genres.forEach(genre -> genreRepository.save(genre));
        // Map the book to search result DTO
        return mapper.map(repository.save(book), BookSearchResultDTO.class);
    }

    public List<BookSearchResultDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(book -> mapper.map(book, BookSearchResultDTO.class))
                .toList();
    }

    public BookSearchResultDTO getBookById(Long id) {
        BookSearchResultDTO bookSearchResultDTO = repository
                .findById(id)
                .map(book -> mapper.map(book, BookSearchResultDTO.class))
                .orElseThrow(() -> new NotFoundException("Book not found"));
        return bookSearchResultDTO;
    }

    public void deleteById(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Book not found");
        }
    }
}
