package com.flatiron.spring.project.SpringFinalProject.controller;

import com.flatiron.spring.project.SpringFinalProject.dto.*;
import com.flatiron.spring.project.SpringFinalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
       return userService.createReadingList(id, createReadingListDTO);
    }

    @GetMapping("/{id}/reading_lists")
    public List<ReadingListByIdDTO> getReadingListByUserId(@PathVariable Long id) {
        return userService.getReadingListByUserId(id);
    }

    @GetMapping("/{id}/reading_lists/{list_id}")
    public List<ReadingListByIdDTO> getReadingListById(@PathVariable("id") Long userId, @PathVariable("list_id") Long id) {
        return userService.getReadingListById(userId, id);
    }
}
