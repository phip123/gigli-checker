package com.poepsi39.giglichecker.service;

import com.poepsi39.giglichecker.model.User;
import com.poepsi39.giglichecker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        this.userRepository.save(user);
    }

    public Optional<User> find(String name) {
        return this.userRepository.findUserByNameContainingIgnoreCase(name);
    }
}
