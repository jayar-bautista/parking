package com.triplejb.parking.entity;

import java.util.List;

public class ParkingAreaReports {

	private int totalSlots;
	private int unoccupiedSlots;
	private List<ParkingSlot> occupiedParkingSlots;
	public int getTotalSlots() {
		return totalSlots;
	}
	public void setTotalSlots(int totalSlots) {
		this.totalSlots = totalSlots;
	}
	public int getUnoccupiedSlots() {
		return unoccupiedSlots;
	}
	public void setUnoccupiedSlots(int unoccupiedSlots) {
		this.unoccupiedSlots = unoccupiedSlots;
	}
	public List<ParkingSlot> getOccupiedParkingSlots() {
		return occupiedParkingSlots;
	}
	public void setOccupiedParkingSlots(List<ParkingSlot> occupiedParkingSlots) {
		this.occupiedParkingSlots = occupiedParkingSlots;
	}
}
