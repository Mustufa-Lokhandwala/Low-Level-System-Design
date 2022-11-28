package factory;

import manager.FourWheelerParkingSpotManager;
import manager.ParkingSpotManager;
import manager.TwoWheelerParkingSpotManager;
import model.enums.VehicleType;
import strategy.parking.DefaultParkingStrategy;

import java.util.ArrayList;

public class ParkingSpotManagerFactory {

    public ParkingSpotManagerFactory() {

    }

    public ParkingSpotManager getParkingSpotManager(VehicleType vehicleType) {
        switch (vehicleType) {
            case TWO_WHEELER:
                return new TwoWheelerParkingSpotManager(new ArrayList<>(), new DefaultParkingStrategy());

            case FOUR_WHEELER:
                return new FourWheelerParkingSpotManager(new ArrayList<>(), new DefaultParkingStrategy());

            default:
                return null;
        }
    }
}
