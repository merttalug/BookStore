package com.example.bookstore.service;

import com.example.bookstore.model.User;

public interface UserService {
    User saveUser(User user);
    User findByUsername(String username);
    boolean loginUser(String username, String password);
}
