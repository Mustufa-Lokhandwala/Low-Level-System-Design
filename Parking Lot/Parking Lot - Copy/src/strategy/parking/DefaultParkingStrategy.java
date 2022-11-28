package strategy.parking;

import model.parkingSpot.ParkingSpot;

import java.util.List;

public class DefaultParkingStrategy implements ParkingStrategy {

    @Override
    public ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpotList) {
        for(ParkingSpot parkingSpot : parkingSpotList) {
            if(parkingSpot.isEmpty()) {
                return parkingSpot;
            }
        }
        return null;
    }
}
