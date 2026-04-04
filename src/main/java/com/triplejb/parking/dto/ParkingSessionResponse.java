package com.triplejb.parking.dto;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParkingSessionResponse {

    private String plateNumber;
    private String slotNumber;
    private Long areaId;

    private LocalDateTime timeIn;
    private LocalDateTime timeOut;

    private String status;
}
