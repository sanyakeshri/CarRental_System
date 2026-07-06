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

    // GET BOOKING BY ID
    public Booking getBookingById(Long id) {

        return bookingRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Booking Not Found"));
    }

    // APPROVE BOOKING
    public Booking approveBooking(Long bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() ->
                        new RuntimeException("Booking Not Found"));

        booking.setStatus("APPROVED");

        return bookingRepository.save(booking);
    }

    // REJECT BOOKING
    public Booking rejectBooking(Long bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() ->
                        new RuntimeException("Booking Not Found"));

        booking.setStatus("REJECTED");

        return bookingRepository.save(booking);
    }

    // GET BOOKINGS BY STATUS
    public List<Booking> getBookingsByStatus(String status) {

        return bookingRepository.findByStatus(status);
    }

    // DELETE BOOKING
    public void deleteBooking(Long id) {

        bookingRepository.deleteById(id);
    }

}