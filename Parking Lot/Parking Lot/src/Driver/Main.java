package Driver;

import model.ParkingLot;
import model.Ticket;
import model.Vehicle;
import model.enums.VehicleType;
import model.parkingSpot.FourWheelerParkingSpot;
import model.parkingSpot.ParkingSpot;
import model.parkingSpot.TwoWheelerParkingSpot;
import model.payment.CashPayment;
import model.payment.OnlinePayment;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Parking Lot !!");

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.addParkingSpot(new TwoWheelerParkingSpot(1, 20.0));
        parkingLot.addParkingSpot(new TwoWheelerParkingSpot(2, 20.0));
        parkingLot.addParkingSpot(new TwoWheelerParkingSpot(3, 20.0));
        parkingLot.addParkingSpot(new FourWheelerParkingSpot(4, 50.0));
        parkingLot.addParkingSpot(new FourWheelerParkingSpot(5, 50.0));
        parkingLot.addParkingSpot(new FourWheelerParkingSpot(6, 50.0));

        Vehicle v1 = new Vehicle(1, VehicleType.CAR);
        Vehicle v2 = new Vehicle(2, VehicleType.BIKE);

        ParkingSpot parkingSpot = parkingLot.findParkingSpot(v1);
        if(parkingSpot != null) {
            Ticket ticket = parkingLot.generateTicket(v1, parkingSpot);
            parkingLot.parkVehicle(v1, parkingSpot);

            CashPayment cashPayment = new CashPayment();
            cashPayment.makePayment(ticket);

            parkingLot.removeVehicle(parkingSpot);
        } else {
            System.out.println("No parking spot available for " + v1);
        }

        parkingSpot = parkingLot.findParkingSpot(v2);
        if(parkingSpot != null) {
            Ticket ticket = parkingLot.generateTicket(v2, parkingSpot);
            parkingLot.parkVehicle(v2, parkingSpot);

            OnlinePayment onlinePayment = new OnlinePayment();
            onlinePayment.makePayment(ticket);

            parkingLot.removeVehicle(parkingSpot);
        } else {
            System.out.println("No parking spot available for " + v2);
        }

    }

}
