package com.triplejb.parking.entity;

public class ParkingSlot {
	
	private Car car;

	public Car getCar() {
		return car;
	}

	public boolean addCar(Car car) {
		if (car == null) {
			this.car = car;
			return true;
		}
		return false;
	}

    public void removeCar() {
    	this.car = null;
    }
}
