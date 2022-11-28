package model.costComputation;

import model.costComputation.CostComputation;
import strategy.pricing.PricingStrategy;

public class TwoWheelerCostComputation extends CostComputation {

    public TwoWheelerCostComputation(PricingStrategy pricingStrategy) {
        super(pricingStrategy);
    }
}
