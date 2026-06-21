package com.sanya.car_rental_backend.repository;

import com.sanya.car_rental_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

    // custom query (we will use later for login)
    User findByEmail(String email);

}
