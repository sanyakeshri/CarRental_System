package com.sanya.car_rental_backend.service;

import com.sanya.car_rental_backend.entity.Booking;
import com.sanya.car_rental_backend.entity.Car;
import com.sanya.car_rental_backend.entity.User;
import com.sanya.car_rental_backend.repository.BookingRepository;
import com.sanya.car_rental_backend.repository.CarRepository;
import com.sanya.car_rental_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;

    public BookingService(
            BookingRepository bookingRepository,
            CarRepository carRepository,
            UserRepository userRepository) {

        this.bookingRepository = bookingRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    public Booking createBooking(Long userId,
                                 Long carId,
                                 Booking booking) {

        User user = userRepository.findById(userId).orElseThrow();
        Car car = carRepository.findById(carId).orElseThrow();

        booking.setUser(user);
        booking.setCar(car);
        booking.setStatus("PENDING");

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}