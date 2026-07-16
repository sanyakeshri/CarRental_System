package com.sanya.car_rental_backend.controller;

import com.sanya.car_rental_backend.repository.BookingRepository;
import com.sanya.car_rental_backend.repository.CarRepository;
import com.sanya.car_rental_backend.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin("*")
public class DashboardController {

    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final BookingRepository bookingRepository;

    public DashboardController(
            UserRepository userRepository,
            CarRepository carRepository,
            BookingRepository bookingRepository) {

        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.bookingRepository = bookingRepository;
    }

//    @GetMapping("/stats")
//    public Map<String, Long> getStats() {
//
//        Map<String, Long> stats = new HashMap<>();
//
//        stats.put("Total Users", userRepository.count());
//
//        stats.put("Total Cars", carRepository.count());
//
//        stats.put("Total Bookings", bookingRepository.count());
//
//        return stats;
//    }

    @GetMapping("/stats")
    public Map<String, Long> getStats() {

        Map<String, Long> stats = new HashMap<>();

        // Overall Counts
        stats.put("Total Users", userRepository.count());
        stats.put("Total Cars", carRepository.count());
        stats.put("Total Bookings", bookingRepository.count());

        // Booking Status Counts
        stats.put("Approved Bookings",
                bookingRepository.countByStatus("APPROVED"));

        stats.put("Pending Bookings",
                bookingRepository.countByStatus("PENDING"));

        stats.put("Rejected Bookings",
                bookingRepository.countByStatus("REJECTED"));

        stats.put("Cancelled Bookings",
                bookingRepository.countByStatus("CANCELLED"));

        return stats;
    }
}
