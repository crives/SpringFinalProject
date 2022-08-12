package com.flatiron.spring.project.SpringFinalProject.controller;

import com.flatiron.spring.project.SpringFinalProject.dto.CreateReadingListDTO;
import com.flatiron.spring.project.SpringFinalProject.dto.CreateUserDTO;
import com.flatiron.spring.project.SpringFinalProject.dto.ReadingListByUserDTO;
import com.flatiron.spring.project.SpringFinalProject.dto.UserSearchResultDTO;
import com.flatiron.spring.project.SpringFinalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/*
POST api/users	- Create a user.
DELETE api/users/{id} -	Delete a user.

GET /api/users/{id}/reading_lists - Gets the given user’s reading lists.
POST /api/users/{id}/reading_lists - Create a new reading list for the user with the given ID.
GET /api/users/{id}/reading_lists/{list_id} - Gets the given user’s reading list with the ID list_id.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserSearchResultDTO createUser(@Valid @RequestBody CreateUserDTO createUserDTO) {
        return userService.create(createUserDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PostMapping("/{id}/reading_lists")
    public ReadingListByUserDTO createReadingListById(@PathVariable Long id, @RequestBody CreateReadingListDTO createReadingListDTO) {
       return userService.createReadingList(createReadingListDTO);
    }
}
