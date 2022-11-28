package manager;

import model.EntranceGate;
import model.parkingSpot.ParkingSpot;
import model.Vehicle;
import strategy.parking.ParkingStrategy;

import java.util.List;

public class ParkingSpotManager {

    private static ParkingSpotManager instance = null;
    private List<ParkingSpot> parkingSpotList;
    private ParkingStrategy parkingStrategy;

    public static ParkingSpotManager getInstance(List<ParkingSpot> parkingSpotList, ParkingStrategy parkingStrategy) {
        if(instance == null)
            instance = new ParkingSpotManager(parkingSpotList, parkingStrategy);
        return instance;
    }

    public ParkingSpotManager(List<ParkingSpot> parkingSpotList, ParkingStrategy parkingStrategy) {
        this.parkingSpotList = parkingSpotList;
        this.parkingStrategy = parkingStrategy;
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
