package model;
import model.enums.VehicleStatus;
import model.enums.VehicleType;

public class Vehicle {
	private int vehicleId;
	private String licenseNumber;
	private double dailyCost;
	private double hourlyCost;
	private VehicleType vehicleType;
	private VehicleStatus vehicleStatus;
	private boolean bookingStatus;
	
	public Vehicle(int vehicleId, String licenseNumber, double dailyCost, double hourlyCost,
				   VehicleType vehicleType) {
		this.vehicleId = vehicleId;
		this.licenseNumber = licenseNumber;
		this.dailyCost = dailyCost;
		this.hourlyCost = hourlyCost;
		this.vehicleType = vehicleType;
		this.vehicleStatus = VehicleStatus.ACTIVE;
		this.bookingStatus = false;
	}
	
	public String getLicenseNumber() {
		return licenseNumber;
	}

	public double getDailyCost() {
		return dailyCost;
	}

	public double getHourlyCost() {
		return hourlyCost;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public VehicleStatus getVehicleStatus() {
		return vehicleStatus;
	}
	
	public boolean getBookingStatus() {
		return bookingStatus;
	}
	
	public void setBookingStatus(boolean status) {
		bookingStatus = status;
	}
	
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", licenseNumber=" + licenseNumber + ", dailyCost=" + dailyCost
				+ ", hourlyCost=" + hourlyCost + ", vehicleType=" + vehicleType + ", vehicleStatus=" + vehicleStatus
				+ "]";
	}
}
