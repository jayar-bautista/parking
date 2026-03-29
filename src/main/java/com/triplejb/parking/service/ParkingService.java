package com.triplejb.parking.service;

import com.triplejb.parking.entity.ParkingAreaReports;

public interface ParkingService {

	void entry(String plateNumber);
	void exit(String plateNumber);
	ParkingAreaReports getParkingAreaReports();
}
