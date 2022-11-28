package strategy.pricing;

import model.Ticket;
import strategy.pricing.PricingStrategy;

public class minutePricingStrategy extends PricingStrategy {
    public double computePrice(Ticket ticket) {
        long minutesParked = System.currentTimeMillis() - ticket.getEntryTime();
        return minutesParked * ticket.getParkingSpot().getPrice();
    }
}
