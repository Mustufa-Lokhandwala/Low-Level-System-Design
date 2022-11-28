package strategy.pricing;

import model.Ticket;

public class PricingStrategy {

    public double computePrice(Ticket ticket) {
        return ticket.getParkingSpot().getPrice();
    }
}
