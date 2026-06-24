package com.sanya.car_rental_backend.service;

import com.sanya.car_rental_backend.Security.JwtUtil;
import com.sanya.car_rental_backend.entity.User;
import com.sanya.car_rental_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired

    private UserRepository repo;



    public String login(
            String email,
            String password
    ){

        User user=
                repo.findByEmail(
                        email
                );

        if(
                user!=null
                        &&
                        user.getPassword()
                                .equals(
                                        password
                                )
        ){

            return JwtUtil
                    .generateToken(
                            email
                    );

        }

        return "INVALID";

    }

}
