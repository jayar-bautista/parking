package com.triplejb.parking.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.triplejb.parking.entity.Car;
import com.triplejb.parking.repository.CarRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public Car findOrCreateCar(String plateNumber) {
        return carRepository.findByPlateNumber(plateNumber)
                .orElseGet(() -> {
                    Car car = new Car();
                    car.setPlateNumber(plateNumber);
                    return carRepository.save(car);
                });
    }

    public Optional<Car> findByPlateNumber(String plateNumber) {
        return carRepository.findByPlateNumber(plateNumber);
    }
}