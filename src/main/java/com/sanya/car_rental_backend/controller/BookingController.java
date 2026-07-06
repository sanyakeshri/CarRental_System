package com.sanya.car_rental_backend.controller;

import com.sanya.car_rental_backend.entity.Booking;
import com.sanya.car_rental_backend.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@CrossOrigin("*")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(
            BookingService bookingService) {

        this.bookingService = bookingService;
    }

    @PostMapping("/book")
    public Booking bookCar(
            @RequestParam Long userId,
            @RequestParam Long carId,
            @RequestBody Booking booking) {

        return bookingService.createBooking(
                userId,
                carId,
                booking
        );
    }

    // APPROVE BOOKING
    @PutMapping("/approve/{id}")
    public Booking approveBooking(
            @PathVariable Long id) {

        return bookingService.approveBooking(id);

    }


    // REJECT BOOKING
    @PutMapping("/reject/{id}")
    public Booking rejectBooking(
            @PathVariable Long id) {

        return bookingService.rejectBooking(id);

    }

    // GET BOOKINGS BY STATUS
    @GetMapping("/status/{status}")
    public List<Booking> getBookingsByStatus(
            @PathVariable String status) {

        return bookingService.getBookingsByStatus(status);

    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
}
