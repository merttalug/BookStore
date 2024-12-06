package com.example.bookstore.service.impl;

import com.example.bookstore.model.User;
import com.example.bookstore.repository.UserRepository;
import com.example.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        logger.info("Saving user with username: {}", user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        logger.info("User saved with ID: {}", savedUser.getId());
        return savedUser;
    }

    @Override
    public User findByUsername(String username) {
        logger.info("Finding user by username: {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean loginUser(String username, String password) {
        logger.info("Authenticating user: {}", username);
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            logger.info("User {} authenticated successfully", username);
            return true;
        } else {
            logger.warn("User {} authentication failed", username);
            return false;
        }
    }
}
