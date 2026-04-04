package com.triplejb.parking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.triplejb.parking.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByPlateNumber(String plateNumber);
}
