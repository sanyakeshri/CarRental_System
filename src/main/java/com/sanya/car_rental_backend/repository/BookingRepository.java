package com.sanya.car_rental_backend.repository;

import com.sanya.car_rental_backend.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}