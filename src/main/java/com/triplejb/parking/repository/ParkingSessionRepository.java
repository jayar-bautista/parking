package com.triplejb.parking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.triplejb.parking.entity.Car;
import com.triplejb.parking.entity.ParkingSession;

public interface ParkingSessionRepository extends JpaRepository<ParkingSession, Long> {

    Optional<ParkingSession> findByCarPlateNumberAndTimeOutIsNull(String plateNumber);

    boolean existsByCarAndTimeOutIsNull(Car car);

    List<ParkingSession> findByTimeOutIsNull();
}
