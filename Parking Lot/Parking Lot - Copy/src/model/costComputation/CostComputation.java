package model.costComputation;

import model.Ticket;
import strategy.pricing.PricingStrategy;

public class CostComputation {
    private PricingStrategy pricingStrategy;

    public CostComputation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double computePrice(Ticket ticket) {
        return pricingStrategy.computePrice(ticket);
    }
}
