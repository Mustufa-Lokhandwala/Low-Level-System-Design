package strategy;

import model.parkingSpot.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {
    public ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpotList);
}
