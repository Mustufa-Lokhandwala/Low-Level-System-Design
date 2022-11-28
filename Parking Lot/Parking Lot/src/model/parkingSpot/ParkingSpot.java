package model.parkingSpot;

import model.Vehicle;
import model.enums.ParkingSpotType;

public class ParkingSpot {
    private int id;
    private boolean isEmpty;
    private Vehicle vehicle;
    private double price;
    private ParkingSpotType parkingSpotType;

    public ParkingSpot(int id, double price, ParkingSpotType parkingSpotType) {
        this.id = id;
        this.price = price;
        this.parkingSpotType = parkingSpotType;
        this.isEmpty = true;
        this.vehicle = null;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isEmpty = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isEmpty = true;
    }

    public int getId() {
        return id;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getPrice() {
        return price;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id=" + id +
                ", isEmpty=" + isEmpty +
                ", vehicle=" + vehicle +
                ", price=" + price +
                ", parkingSpotType=" + parkingSpotType +
                '}';
    }
}
