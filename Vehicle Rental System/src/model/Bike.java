package model;

import model.enums.VehicleType;

public class Bike extends Vehicle {

	public Bike(int id, String licenseNumber, double dailyCost, double hourlyCost) {
		super(id, licenseNumber, dailyCost, hourlyCost, VehicleType.BIKE);
	}

}
