package factory;

import model.costComputation.CostComputation;
import model.costComputation.FourWheelerCostComputation;
import model.Ticket;
import model.costComputation.TwoWheelerCostComputation;
import model.enums.VehicleType;
import strategy.pricing.hourlyPricingStrategy;
import strategy.pricing.minutePricingStrategy;

public class CostComputationFactory {

    public CostComputation getCostComputationObject(Ticket ticket) {
        VehicleType vehicleType = ticket.getParkingSpot().getVehicle().getVehicleType();
        switch(vehicleType) {
            case TWO_WHEELER:
                return new TwoWheelerCostComputation(new hourlyPricingStrategy());

            case FOUR_WHEELER:
                return new FourWheelerCostComputation(new minutePricingStrategy());

            default:
                return null;
        }
    }

}
