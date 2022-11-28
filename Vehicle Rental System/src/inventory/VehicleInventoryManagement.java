package inventory;
import java.util.ArrayList;
import java.util.List;

import model.Vehicle;

public class VehicleInventoryManagement {
	private List<Vehicle> vehicles;

	public VehicleInventoryManagement() {
		vehicles = new ArrayList<Vehicle>();
	}
	
	public void addVehicle(Vehicle v) {
		vehicles.add(v);
	}
	
	public void removeVehicle(Vehicle v) {
		vehicles.remove(v);
	}
	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	
	@Override
	public String toString() {
		return "VehicleInventoryManagement [vehicles=" + vehicles + "]";
	}
}
