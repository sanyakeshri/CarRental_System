package com.sanya.car_rental_backend.service;

import com.sanya.car_rental_backend.entity.Car;
import com.sanya.car_rental_backend.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    // ADD CAR
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    // GET ALL CARS
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // GET BY ID
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    // DELETE CAR
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}