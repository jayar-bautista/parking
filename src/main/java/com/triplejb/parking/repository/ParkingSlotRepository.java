package com.triplejb.parking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.triplejb.parking.entity.ParkingSlot;
import com.triplejb.parking.enums.SlotStatus;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {

    Optional<ParkingSlot> findFirstByParkingAreaIdAndStatus(Long parkingAreaId, SlotStatus status);
}
