package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import inventory.BikeInventoryManagement;
import inventory.CarInventoryManagement;
import inventory.VehicleInventoryManagement;
import model.enums.ReservationStatus;
import model.enums.ReservationType;
import model.enums.VehicleType;

public class Store {
	private int storeId;
	private Location location;
	private VehicleInventoryManagement carInventoryManagement;
	private VehicleInventoryManagement bikeInventoryManagement;
	private List<Reservation> reservations;
	
	public Store(int storeId, Location location) {
		this.storeId = storeId;
		this.location = location;
		this.carInventoryManagement = new CarInventoryManagement();
		this.bikeInventoryManagement = new BikeInventoryManagement();
		this.reservations = new ArrayList<Reservation>();
	}

	public void addVehicle(Vehicle vehicle) {
		switch(vehicle.getVehicleType()) {
			case CAR: 
				carInventoryManagement.addVehicle(vehicle);
				break;
			case BIKE:
				bikeInventoryManagement.addVehicle(vehicle);
				break;
			default:
				System.out.println("Type of vehicle is invalid");
				break;
		}
	}

	public void removeVehicle(Vehicle vehicle) {
		switch(vehicle.getVehicleType()) {
			case CAR: 
				carInventoryManagement.removeVehicle(vehicle);
				break;
			case BIKE:
				bikeInventoryManagement.removeVehicle(vehicle);
				break;
			default:
				System.out.println("Type of vehicle is invalid");
				break;
		}
	}
	
	public List<Vehicle> getVehicles(VehicleType vehicleType) { // Can pass other filters here like rental charges etc.
		switch(vehicleType) {
			case CAR:
				return carInventoryManagement.getVehicles();
			case BIKE:
				return bikeInventoryManagement.getVehicles();
			default:
				return new ArrayList<Vehicle>();
		}
	}
	
	public Reservation createReservation(User user, Vehicle vehicle, Date bookedFromDate, Date bookedToDate, long bookedFromTime,
										 long bookedToTime, Location pickupLocation, Location dropoffLocation, ReservationType reservationType) {
		int reservationId = reservations.size();
		Date bookingDate = new Date();
		Reservation reservation = new Reservation(reservationId, user, vehicle, bookingDate, bookedFromDate, bookedToDate, 
				 								  bookedFromTime, bookedToTime, pickupLocation, dropoffLocation, reservationType);
		 
		vehicle.setBookingStatus(true);
		reservations.add(reservation);
		
		return reservation;
	}
	
	public void completeReservation(Reservation reservation) {
		for(Reservation r : this.reservations) {
			if(r.equals(reservation)) {
				r.setReservationStatus(ReservationStatus.COMPLETED);
				r.getVehicle().setBookingStatus(false);
			}
		}
	}
	 
	public int getStoreId() {
		return storeId;
	}

	public Location getLocation() {
		return location;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}
	
	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", location=" + location + ", carInventoryManagement="
				+ carInventoryManagement + ", bikeInventoryManagement=" + bikeInventoryManagement + "]";
	}
}
