package com.sanya.car_rental_backend.repository;

import com.sanya.car_rental_backend.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCarId(Long carId);

    List<Booking> findByStatus(String status);
}