package com.triplejb.parking.entity;

import java.util.ArrayList;
import java.util.List;

public class ParkingArea {
	private int totalParkingSlot;
	private List<ParkingSlot> parkingSlots;

	public ParkingArea(int totalParkingSlot) {
		super();
		this.totalParkingSlot = totalParkingSlot;
		parkingSlots = new ArrayList<ParkingSlot>(totalParkingSlot);
	}
	
	public int getTotalParkingSlot() {
		return totalParkingSlot;
	}

	public ParkingSlot getAvailableParkingSlot() {
		for (ParkingSlot parkingSlot: parkingSlots) {
			if (parkingSlot == null) {
				parkingSlot = new ParkingSlot();
				return parkingSlot;
			} else if (parkingSlot.getCar() == null) {
				return parkingSlot;
			}
		}
		return null;
	}
	
	public List<ParkingSlot> getOccupiedParkingSlots() {
		List<ParkingSlot> occupiedParkingSlots = new ArrayList<>();
		for (ParkingSlot parkingSlot: parkingSlots) {
			if (parkingSlot != null && parkingSlot.getCar() != null) {
				occupiedParkingSlots.add(parkingSlot);
			}
		}
		return occupiedParkingSlots;
	}
}
