package com.triplejb.parking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.triplejb.parking.entity.Car;
import com.triplejb.parking.entity.ParkingArea;
import com.triplejb.parking.entity.ParkingAreaReports;
import com.triplejb.parking.entity.ParkingSlot;

@Service
public class BasicParkingService implements ParkingService {

	private ParkingArea parkingArea = new ParkingArea(60);
	
	@Override
	public void entry(String plateNumber) {
		Car car = new Car(plateNumber);
		ParkingSlot parkingSlot = parkingArea.getAvailableParkingSlot();
		if (parkingSlot != null) {
			parkingSlot.addCar(car);
		}	
	}

	@Override
	public void exit(String plateNumber) {
		List<ParkingSlot> occupiedParkingSlots = parkingArea.getOccupiedParkingSlots();
		for (ParkingSlot parkingSlot: occupiedParkingSlots) {
			if (parkingSlot.getCar().getPlateNumber().equalsIgnoreCase(plateNumber)) {
				parkingSlot.removeCar();
			}
		}
	}

	@Override
	public ParkingAreaReports getParkingAreaReports() {
		ParkingAreaReports parkingAreaReports = new ParkingAreaReports();
		parkingAreaReports.setTotalSlots(parkingArea.getTotalParkingSlot());
		parkingAreaReports.setUnoccupiedSlots(parkingArea.getTotalParkingSlot() - parkingArea.getOccupiedParkingSlots().size());
		parkingAreaReports.setOccupiedParkingSlots(parkingArea.getOccupiedParkingSlots());
		return parkingAreaReports;
	}
}