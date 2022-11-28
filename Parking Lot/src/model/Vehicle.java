package model;

import model.enums.VehicleType;

public class Vehicle {
    private int vehicleNo;
    private VehicleType vehicleType;

    public Vehicle(int vehicleNo, VehicleType vehicleType) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
    }

    public int getVehicleNo() {
        return vehicleNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNo=" + vehicleNo +
                ", vehicleType=" + vehicleType +
                '}';
    }

}
