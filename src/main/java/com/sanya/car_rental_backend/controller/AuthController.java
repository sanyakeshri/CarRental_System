package com.sanya.car_rental_backend.controller;

import com.sanya.car_rental_backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController

@RequestMapping(
        "/auth"
)

public class AuthController {

    @Autowired

    private AuthService auth;



    @PostMapping(
            "/login"
    )

    public String login(
            @RequestBody
            Map<String,String>
                    body
    ){

        return auth.login(

                body.get(
                        "email"
                ),

                body.get(
                        "password"
                )

        );

    }

}
