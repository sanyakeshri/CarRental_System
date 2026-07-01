package com.sanya.car_rental_backend.service;

import com.sanya.car_rental_backend.Security.JwtUtil;
import com.sanya.car_rental_backend.entity.User;
import com.sanya.car_rental_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String login(String email, String password) {

        // Find user by email
        User user = repo.findByEmail(email);

        // Check if user exists
        if (user == null) {
            return "User Not Found";
        }

        // Compare entered password with encrypted password
        if (passwordEncoder.matches(password, user.getPassword())) {

            // Generate JWT Token
            return JwtUtil.generateToken(email);

        }

        return "Invalid Password";
    }

}