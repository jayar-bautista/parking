package com.triplejb.parking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triplejb.parking.dto.ParkCarRequest;
import com.triplejb.parking.dto.ParkingSessionResponse;
import com.triplejb.parking.dto.UnparkCarRequest;
import com.triplejb.parking.service.ParkingSessionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/parking")
@RequiredArgsConstructor
public class ParkingController {

    private final ParkingSessionService parkingSessionService;

    /**
     * 1. Park a car
     */
    @PostMapping("/park")
    public ParkingSessionResponse parkCar(@RequestBody ParkCarRequest request) {
        return parkingSessionService.parkCar(
                request.getPlateNumber(),
                request.getAreaId()
        );
    }

    /**
     * 2. Unpark a car
     */
    @PostMapping("/unpark")
    public ParkingSessionResponse unparkCar(@RequestBody UnparkCarRequest request) {
        return parkingSessionService.unparkCar(
                request.getPlateNumber()
        );
    }

    /**
     * 3. List all currently parked cars
     */
    @GetMapping("/active")
    public List<ParkingSessionResponse> getActiveSessions() {
        return parkingSessionService.getActiveSessions();
    }
}