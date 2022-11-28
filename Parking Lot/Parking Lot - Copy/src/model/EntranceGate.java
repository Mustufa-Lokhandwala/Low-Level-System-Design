package model;

import factory.ParkingSpotManagerFactory;
import manager.ParkingSpotManager;
import model.parkingSpot.ParkingSpot;

public class EntranceGate {

    private ParkingSpotManagerFactory parkingSpotManagerFactory;

    public EntranceGate() {
        parkingSpotManagerFactory = new ParkingSpotManagerFactory();
    }

    public ParkingSpot findParkingSpot(Vehicle vehicle) {
        ParkingSpotManager parkingSpotManager = parkingSpotManagerFactory.getParkingSpotManager(vehicle.getVehicleType());
        return parkingSpotManager.findParkingSpot();
    }

    public void bookParkingSpot(Vehicle vehicle, ParkingSpot parkingSpot) {
        ParkingSpotManager parkingSpotManager = parkingSpotManagerFactory.getParkingSpotManager(vehicle.getVehicleType());
        parkingSpotManager.parkVehicle(vehicle, parkingSpot);
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        return new Ticket(System.currentTimeMillis(), vehicle, parkingSpot);
    }
}
