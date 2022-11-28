package model.parkingSpot;

import model.parkingSpot.ParkingSpot;

import static model.enums.ParkingSpotType.TWO_WHEELER_SPOT;

public class TwoWheelerParkingSpot extends ParkingSpot {

    public TwoWheelerParkingSpot(int id, double price) {
        super(id, price, TWO_WHEELER_SPOT);
    }
}
