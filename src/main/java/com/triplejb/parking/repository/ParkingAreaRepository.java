package com.triplejb.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.triplejb.parking.entity.ParkingArea;

public interface ParkingAreaRepository extends JpaRepository<ParkingArea, Long> {
}