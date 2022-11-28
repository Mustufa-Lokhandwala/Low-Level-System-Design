package manager;

import model.parkingSpot.ParkingSpot;
import model.Vehicle;
import strategy.DefaultParkingStrategy;
import strategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotManager {

    private List<ParkingSpot> parkingSpotList;
    private ParkingStrategy parkingStrategy;

    public ParkingSpotManager() {
        this.parkingSpotList = new ArrayList<>();
        this.parkingStrategy = new DefaultParkingStrategy();
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        parkingSpotList.add(parkingSpot);
    }

    public void removeParkingSpot(ParkingSpot parkingSpot) {
        parkingSpotList.remove(parkingSpot);
    }

    public ParkingSpot findParkingSpot() {
        return parkingStrategy.findParkingSpot(parkingSpotList);
    }

    public void parkVehicle(Vehicle vehicle, ParkingSpot parkingSpot) {
        parkingSpot.parkVehicle(vehicle);
    }

    public void removeVehicle(ParkingSpot parkingSpot) {
        parkingSpot.removeVehicle();
    }
}
