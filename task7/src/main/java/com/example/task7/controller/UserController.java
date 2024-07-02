package com.example.task7.controller;

import com.example.task7.model.User;
import com.example.task7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users-starting-with-h")
    public Page<User> getUsersStartingWithH(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return userService.findUsersStartingWithH(page, size);
    }
    @GetMapping("/users-containing-h")
    public Page<User> getUsersContainingH(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return userService.findUsersContainingH(page, size);
    }
    @GetMapping("/fullname")
    public Page<User> getUsersByName(
            @RequestParam String firstName,
            @RequestParam String middleName,
            @RequestParam String lastName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return userService.findUsersByName(firstName, middleName, lastName, page, size);
    }
}
