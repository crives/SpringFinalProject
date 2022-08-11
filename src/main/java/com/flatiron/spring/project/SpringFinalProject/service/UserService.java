package com.flatiron.spring.project.SpringFinalProject.service;

import com.flatiron.spring.project.SpringFinalProject.dto.CreateUserDTO;
import com.flatiron.spring.project.SpringFinalProject.dto.UserSearchResultDTO;
import com.flatiron.spring.project.SpringFinalProject.exception.NotFoundException;
import com.flatiron.spring.project.SpringFinalProject.model.User;
import com.flatiron.spring.project.SpringFinalProject.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    public UserSearchResultDTO create(CreateUserDTO createUserDTO) {
        User user = mapper.map(createUserDTO, User.class);
        return mapper.map(repository.save(user), UserSearchResultDTO.class);
    }

    public UserSearchResultDTO getById(Long id) {
        UserSearchResultDTO userResultDTO = repository
                .findById(id)
                .map(user -> mapper.map(user,
                        UserSearchResultDTO.class)).orElseThrow(() -> new NotFoundException("User not found"));
//        TODO check below:
//        userResultDTO.setActivities(signupService.getActivitiesByCamperId(id));
        return userResultDTO;
    }

    public void deleteById(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("User not found");
        }
    }
}
