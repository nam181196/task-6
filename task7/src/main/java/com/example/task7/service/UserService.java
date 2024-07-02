package com.example.task7.service;

import com.example.task7.model.User;
import com.example.task7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> findUsersStartingWithH(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return userRepository.findByFirstNameStartingWith("H", pageable);
    }

    public Page<User> findUsersContainingH(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return userRepository.findByFirstNameContaining("H", pageable);
    }
    public Page<User> findUsersByName(String firstName, String middleName, String lastName, int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return userRepository.findByFirstNameAndMiddleNameAndLastName(firstName, middleName, lastName, pageable);
    }

}