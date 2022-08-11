package com.flatiron.spring.project.SpringFinalProject.service;

import com.flatiron.spring.project.SpringFinalProject.dto.CreateUserDTO;
import com.flatiron.spring.project.SpringFinalProject.dto.UserSearchResultDTO;
import com.flatiron.spring.project.SpringFinalProject.exception.NotFoundException;
import com.flatiron.spring.project.SpringFinalProject.model.User;
import com.flatiron.spring.project.SpringFinalProject.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

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


}
