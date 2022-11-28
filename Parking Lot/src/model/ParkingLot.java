package model;

import manager.FourWheelerParkingSpotManager;
import manager.ParkingSpotManager;
import manager.TwoWheelerParkingSpotManager;
import model.enums.ParkingSpotType;
import model.parkingSpot.ParkingSpot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private Map<ParkingSpotType, ParkingSpotManager> parkingSpotManagerMap;

    public ParkingLot() {
        this.parkingSpotManagerMap = new HashMap<>();
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        ParkingSpotType parkingSpotType = parkingSpot.getParkingSpotType();

        switch(parkingSpotType) {
            case TWO_WHEELER_SPOT:
                if(!parkingSpotManagerMap.containsKey(ParkingSpotType.TWO_WHEELER_SPOT))
                    parkingSpotManagerMap.put(ParkingSpotType.TWO_WHEELER_SPOT, new TwoWheelerParkingSpotManager());
                parkingSpotManagerMap.get(parkingSpotType).addParkingSpot(parkingSpot);
                break;

            case FOUR_WHEELER_SPOT:
                if(!parkingSpotManagerMap.containsKey(ParkingSpotType.FOUR_WHEELER_SPOT))
                    parkingSpotManagerMap.put(ParkingSpotType.FOUR_WHEELER_SPOT, new FourWheelerParkingSpotManager());
                parkingSpotManagerMap.get(parkingSpotType).addParkingSpot(parkingSpot);
                break;

            default:
                break;
        }
    }

    public void removeParkingSpot(ParkingSpot parkingSpot) {
        parkingSpotManagerMap.get(parkingSpot.getParkingSpotType()).removeParkingSpot(parkingSpot);
    }

    public ParkingSpot findParkingSpot(Vehicle vehicle) {
        ParkingSpot parkingSpot;

        switch(vehicle.getVehicleType()) {
            case BIKE: // Bike can be parked in either Two Wheeler or Four Wheeler Spot.
                parkingSpot = parkingSpotManagerMap.get(ParkingSpotType.TWO_WHEELER_SPOT).findParkingSpot();
                if(parkingSpot != null)
                    return parkingSpot;
                return parkingSpotManagerMap.get(ParkingSpotType.FOUR_WHEELER_SPOT).findParkingSpot();

            case CAR: // Car can only be parked in Four Wheeler Spot.
                return parkingSpotManagerMap.get(ParkingSpotType.FOUR_WHEELER_SPOT).findParkingSpot();

            default:
                return null;
        }
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        return new Ticket(vehicle, parkingSpot);
    }

    public void parkVehicle(Vehicle vehicle, ParkingSpot parkingSpot) {
        parkingSpotManagerMap.get(parkingSpot.getParkingSpotType()).parkVehicle(vehicle, parkingSpot);
    }

    public void removeVehicle(ParkingSpot parkingSpot) {
        parkingSpotManagerMap.get(parkingSpot.getParkingSpotType()).removeVehicle(parkingSpot);
    }
}
