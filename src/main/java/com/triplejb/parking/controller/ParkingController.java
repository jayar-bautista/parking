package com.triplejb.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triplejb.parking.entity.ParkingAreaReports;
import com.triplejb.parking.service.ParkingService;

@RestController
@RequestMapping("/parking")
public class ParkingController {

	private ParkingService parkingService;
	
	@Autowired
	public ParkingController (ParkingService parkingService) {
		this.parkingService = parkingService;
	}
	
	@GetMapping
	@RequestMapping("reports")
	public ParkingAreaReports getParkingAreaReports () {
		return this.parkingService.getParkingAreaReports();
	}
}
