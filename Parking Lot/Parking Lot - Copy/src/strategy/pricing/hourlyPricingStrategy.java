package strategy.pricing;

import model.Ticket;
import strategy.pricing.PricingStrategy;

public class hourlyPricingStrategy extends PricingStrategy {
    public double computePrice(Ticket ticket) {
        long hoursParked = System.currentTimeMillis() - ticket.getEntryTime();
        return hoursParked * ticket.getParkingSpot().getPrice();
    }
}
