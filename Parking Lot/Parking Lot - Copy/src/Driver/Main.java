package Driver;

import manager.FourWheelerParkingSpotManager;
import manager.ParkingSpotManager;
import manager.TwoWheelerParkingSpotManager;
import model.EntranceGate;
import model.parkingSpot.ParkingSpot;
import model.Ticket;
import model.Vehicle;
import model.enums.VehicleType;
import strategy.parking.DefaultParkingStrategy;

import java.util.ArrayList;
import java.util.List;

import static model.enums.ParkingSpotType.FOUR_WHEELER_SPOT;
import static model.enums.ParkingSpotType.TWO_WHEELER_SPOT;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Parking Lot !!");

        List<ParkingSpot> twoWheelerSpots = new ArrayList<>();
        twoWheelerSpots.add(new ParkingSpot(1, 20.0, TWO_WHEELER_SPOT));
        twoWheelerSpots.add(new ParkingSpot(2, 20.0, TWO_WHEELER_SPOT));
        twoWheelerSpots.add(new ParkingSpot(3, 20.0, TWO_WHEELER_SPOT));

        List<ParkingSpot> fourWheelerSpots = new ArrayList<>();
        fourWheelerSpots.add(new ParkingSpot(4, 50.0, FOUR_WHEELER_SPOT));
        fourWheelerSpots.add(new ParkingSpot(5, 50.0, FOUR_WHEELER_SPOT));
        fourWheelerSpots.add(new ParkingSpot(6, 50.0, FOUR_WHEELER_SPOT));

        ParkingSpotManager parkingSpotManager1 = new TwoWheelerParkingSpotManager(twoWheelerSpots,
                                                                                  new DefaultParkingStrategy());
        ParkingSpotManager parkingSpotManager2 = new FourWheelerParkingSpotManager(fourWheelerSpots,
                                                                                   new DefaultParkingStrategy());

        Vehicle vehicle1 = new Vehicle(1, VehicleType.TWO_WHEELER);
        Vehicle vehicle2 = new Vehicle(2, VehicleType.FOUR_WHEELER);

        EntranceGate entranceGate = new EntranceGate();

        ParkingSpot parkingSpot1 = entranceGate.findParkingSpot(vehicle1);
        if(parkingSpot1 != null) {
            entranceGate.bookParkingSpot(vehicle1, parkingSpot1);
            Ticket ticket1 = entranceGate.generateTicket(vehicle1, parkingSpot1);
            System.out.println(ticket1);
        }
        else
            System.out.println("No parking spot available for " + vehicle1);

        ParkingSpot parkingSpot2 = entranceGate.findParkingSpot(vehicle2);
        if(parkingSpot2 != null) {
            entranceGate.bookParkingSpot(vehicle2, parkingSpot2);
            Ticket ticket2 = entranceGate.generateTicket(vehicle2, parkingSpot2);
            System.out.println(ticket2);
        }
        else
            System.out.println("No parking spot available for " + vehicle2);


    }

}
