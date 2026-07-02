package com.sanya.car_rental_backend.repository;

import com.sanya.car_rental_backend.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
