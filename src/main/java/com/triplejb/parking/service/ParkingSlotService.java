package com.triplejb.parking.service;

import org.springframework.stereotype.Service;

import com.triplejb.parking.entity.ParkingSlot;
import com.triplejb.parking.enums.SlotStatus;
import com.triplejb.parking.repository.ParkingSlotRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParkingSlotService {

    private final ParkingSlotRepository slotRepository;

    public ParkingSlot findAvailableSlot(Long areaId) {
        return slotRepository
                .findFirstByParkingAreaIdAndStatus(areaId, SlotStatus.AVAILABLE)
                .orElseThrow(() -> new RuntimeException("No available slots"));
    }

    public void occupySlot(ParkingSlot slot) {
        slot.setStatus(SlotStatus.OCCUPIED);
        slotRepository.save(slot);
    }

    public void releaseSlot(ParkingSlot slot) {
        slot.setStatus(SlotStatus.AVAILABLE);
        slotRepository.save(slot);
    }
}