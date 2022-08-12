package com.flatiron.spring.project.SpringFinalProject.service;

import com.flatiron.spring.project.SpringFinalProject.dto.CreateReadingListDTO;
import com.flatiron.spring.project.SpringFinalProject.dto.CreateUserDTO;
import com.flatiron.spring.project.SpringFinalProject.dto.ReadingListByUserDTO;
import com.flatiron.spring.project.SpringFinalProject.dto.UserSearchResultDTO;
import com.flatiron.spring.project.SpringFinalProject.exception.NotFoundException;
import com.flatiron.spring.project.SpringFinalProject.exception.ValidationException;
import com.flatiron.spring.project.SpringFinalProject.model.ReadingList;
import com.flatiron.spring.project.SpringFinalProject.model.User;
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

    public List<ReadingListByUserDTO> getReadingListById(Long id) {
    List<ReadingList> readingListByUserId = repository.findAllReadingListById(id);
    return readingListByUserId.stream()
            .map(readingList -> mapper.map(readingList, ReadingListByUserDTO.class))
            .toList();
    }

//    public List<ReadingListByIdDTO> getListByListId(Long id) {
//        List<ReadingList> readingListByListId = repository.findAllById(id);
//        return readingListByListId
//                .stream()
//                .map(readingList -> mapper.map(readingList, ReadingListByIdDTO.class))
//                .toList();
//    }

    // Create a new reading list for the user with the given user ID
    public ReadingListByUserDTO createReadingList(CreateReadingListDTO createReadingListDTO) {
        ReadingList readingList = new ReadingList();
        readingList.setName(createReadingListDTO.getName());
        readingList.setUser(
                getUserById(
                        createReadingListDTO.getId()
                        ).orElseThrow(() -> new ValidationException()));


//        readingList.setBooks(createReadingListDTO.getBooks());
        readingList = readingListRepository.save(readingList);
        return mapper.map(readingList, ReadingListByUserDTO.class);
    }
}
