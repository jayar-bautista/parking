package com.triplejb.parking.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.triplejb.parking.dto.ParkingSessionResponse;
import com.triplejb.parking.entity.Car;
import com.triplejb.parking.entity.ParkingSession;
import com.triplejb.parking.entity.ParkingSlot;
import com.triplejb.parking.enums.SessionStatus;
import com.triplejb.parking.repository.ParkingSessionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParkingSessionService {

    private final CarService carService;
    private final ParkingSlotService slotService;
    private final ParkingSessionRepository sessionRepository;

    @Transactional
    public ParkingSessionResponse parkCar(String plateNumber, Long areaId) {

        // 1. Find or create car
        Car car = carService.findOrCreateCar(plateNumber);

        // 2. Check if already parked
        boolean alreadyParked = sessionRepository.existsByCarAndTimeOutIsNull(car);
        if (alreadyParked) {
            throw new RuntimeException("Car is already parked");
        }

        // 3. Get available slot
        ParkingSlot slot = slotService.findAvailableSlot(areaId);

        // 4. Occupy slot
        slotService.occupySlot(slot);

        // 5. Create session
        ParkingSession session = new ParkingSession();
        session.setCar(car);
        session.setParkingSlot(slot);
        session.setTimeIn(LocalDateTime.now());
        session.setStatus(SessionStatus.ACTIVE);

        return mapToResponse(sessionRepository.save(session));
    }

    @Transactional
    public ParkingSessionResponse unparkCar(String plateNumber) {

        // 1. Find active session
        ParkingSession session = sessionRepository
                .findByCarPlateNumberAndTimeOutIsNull(plateNumber)
                .orElseThrow(() -> new RuntimeException("Car not parked"));

        // 2. Set timeout
        session.setTimeOut(LocalDateTime.now());
        session.setStatus(SessionStatus.COMPLETED);

        // 3. Release slot
        slotService.releaseSlot(session.getParkingSlot());

        return mapToResponse(sessionRepository.save(session));
    }

    public List<ParkingSessionResponse> getActiveSessions() {
        return sessionRepository.findByTimeOutIsNull()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private ParkingSessionResponse mapToResponse(ParkingSession session) {
        return ParkingSessionResponse.builder()
                .plateNumber(session.getCar().getPlateNumber())
                .slotNumber(session.getParkingSlot().getSlotNumber())
                .areaId(session.getParkingSlot().getParkingArea().getId())
                .timeIn(session.getTimeIn())
                .timeOut(session.getTimeOut())
                .status(session.getStatus().name())
                .build();
    }
}
