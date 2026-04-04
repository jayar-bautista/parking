package com.triplejb.parking.dto;

import lombok.Data;

@Data
public class ParkCarRequest {
    private String plateNumber;
    private Long areaId;
}
