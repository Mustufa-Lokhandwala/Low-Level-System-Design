package model;

import factory.ParkingSpotManagerFactory;
import manager.ParkingSpotManager;
import model.costComputation.CostComputation;

public class ExitGate {
    private Ticket ticket;
    private CostComputation costComputationObj;
    private ParkingSpotManagerFactory parkingSpotManagerFactory;
    private ParkingSpotManager parkingSpotManager;

    public ExitGate(Ticket ticket) {
        this.ticket = ticket;
    }


    public double calculatePrice() {
        return costComputationObj.computePrice(ticket);
    }

    public void removeVehicle() {
        parkingSpotManager = parkingSpotManagerFactory.getParkingSpotManager(ticket.getVehicle().getVehicleType());
        parkingSpotManager.removeVehicle(ticket.getParkingSpot());
    }

}
