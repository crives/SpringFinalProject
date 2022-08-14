package com.flatiron.spring.project.SpringFinalProject.service;

import com.flatiron.spring.project.SpringFinalProject.dto.*;
import com.flatiron.spring.project.SpringFinalProject.exception.NotFoundException;
import com.flatiron.spring.project.SpringFinalProject.exception.ValidationException;
import com.flatiron.spring.project.SpringFinalProject.model.Book;
import com.flatiron.spring.project.SpringFinalProject.model.ReadingList;
import com.flatiron.spring.project.SpringFinalProject.model.User;
import com.flatiron.spring.project.SpringFinalProject.repository.BookRepository;
import com.flatiron.spring.project.SpringFinalProject.repository.ReadingListRepository;
import com.flatiron.spring.project.SpringFinalProject.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ReadingListRepository readingListRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper mapper;

    public UserSearchResultDTO create(CreateUserDTO createUserDTO) {
        User user = mapper.map(createUserDTO, User.class);
        return mapper.map(repository.save(user), UserSearchResultDTO.class);
    }

    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("User not found");
        }
    }

    public List<ReadingListByIdDTO> getReadingListById(Long userId, Long id) {
    List<ReadingList> readingListById = readingListRepository.findAllByIdAndUserId(userId, id);
    return readingListById
            .stream()
            .map(readingList -> mapper.map(readingList, ReadingListByIdDTO.class))
            .toList();
    }

    public List<ReadingListByIdDTO> getReadingListByUserId(Long id) {
        List<ReadingList> readingListByListId = readingListRepository.findAllByUserId(id);
        return readingListByListId
                .stream()
                .map(readingList -> mapper.map(readingList, ReadingListByIdDTO.class))
                .toList();
    }

    // Create a new reading list for the user with the given user ID
    public ReadingListByUserDTO createReadingList(Long id, CreateReadingListDTO createReadingListDTO) {
        ReadingList readingList = new ReadingList();
        readingList.setName(createReadingListDTO.getName());
        readingList.setUser(
                getUserById(id).orElseThrow(() -> new ValidationException()));

        List<BookDTO> readingListDTOBookList = createReadingListDTO.getBooks();
        List<String> bookTitleList = readingListDTOBookList
                .stream()
                .map(book -> book.getTitle())
                .toList();
        List<Book> bookList = bookRepository.findAllByTitleIn(bookTitleList);

        readingList.setBooks(bookList);
        readingList = readingListRepository.save(readingList);

        return mapper.map(readingList, ReadingListByUserDTO.class);
    }
}
