package com.sanya.car_rental_backend.service;

import com.sanya.car_rental_backend.entity.User;
import com.sanya.car_rental_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // SAVE USER
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // GET ALL USERS
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET USER BY EMAIL
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);


    }
}
