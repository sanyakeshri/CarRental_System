package com.sanya.car_rental_backend.Security;

import com.sanya.car_rental_backend.entity.User;
import com.sanya.car_rental_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService
        implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user =
                userRepository.findByEmail(email);

        if (user == null) {

            throw new UsernameNotFoundException(
                    "User Not Found"
            );

        }

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities("ROLE_CUSTOMER")
                .build();

    }

}
