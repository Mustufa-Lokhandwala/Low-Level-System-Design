package model.parkingSpot;

import model.parkingSpot.ParkingSpot;

import static model.enums.ParkingSpotType.FOUR_WHEELER_SPOT;

public class FourWheelerParkingSpot extends ParkingSpot {

    public FourWheelerParkingSpot(int id, double price) {
        super(id, price, FOUR_WHEELER_SPOT);
    }
}
