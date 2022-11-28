package model;

import model.enums.VehicleType;

public class Car extends Vehicle {

	public Car(int id, String licenseNumber, double dailyCost, double hourlyCost) {
		super(id, licenseNumber, dailyCost, hourlyCost, VehicleType.CAR);
	}
}
