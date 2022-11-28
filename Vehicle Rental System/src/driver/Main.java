package driver;

import java.util.ArrayList;
import java.util.List;

import model.Bike;
import model.Bill;
import model.Car;
import model.CashPayment;
import model.Location;
import model.OnlinePayment;
import model.Reservation;
import model.Store;
import model.User;
import model.Vehicle;
import model.enums.ReservationType;
import model.enums.VehicleType;
import service.VehicleRentalService;

public class Main {

	public static void main(String[] args) {
		List<User> users = createUsers();
		List<Vehicle> vehicles = createVehicles();
		List<Store> stores = createStores(vehicles);
		
		VehicleRentalService service = new VehicleRentalService();
		service.setUsers(users);
		service.setStores(stores);

		// Step 1: user comes
		User user = users.get(0);
		
		// Step 2: user searches for stores based on location
		Location location = new Location(1, "Yerwada", "Pune", "Maharashtra", 333031);
		List<Store> nearbyStores = service.getStores(location);

		// Step 3: get all vehicle(s) user is interested in based upon different filters.
		List<Vehicle> storeVehicles = nearbyStores.get(0).getVehicles(VehicleType.CAR);
		
		// Step 4: reserve a particular vehicle
		Reservation reservation = nearbyStores.get(0)
											  .createReservation(user, storeVehicles.get(0), null, null, 1150,
															  	 2350, null, null, ReservationType.DAILY);
		
		// Step 5: generate the bill
		Bill bill = new Bill(reservation);
		
		// Step 6: make payment
		OnlinePayment payment = new OnlinePayment();
		payment.payBill(bill);
		
		// Step 7: trip completed, submit vehicle and close reservation
		nearbyStores.get(0).completeReservation(reservation);
		
	}

	private static List<User> createUsers() {	
		List<User> users = new ArrayList<User>();
		users.add(new User(1, "Mustufa", "MU012"));
		users.add(new User(2, "Fatema", "FA012"));
		users.add(new User(3, "Abbas", "AB012"));
		users.add(new User(4, "Murtuza", "MR012"));

		return users;
	}

	private static List<Store> createStores(List<Vehicle> vehicles) {
		List<Store> stores = new ArrayList<Store>();
		
		Location location = new Location(1, "Yerwada", "Pune", "Maharashtra", 333031);
		
		Store store1 = new Store(1, location);
		for(Vehicle v : vehicles) 
			store1.addVehicle(v);
		
		stores.add(store1);
		return stores;
	}
	
	private static List<Vehicle> createVehicles() {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		vehicles.add(new Car(1, "MH03P0123", 1000.0, 50.0));
		vehicles.add(new Bike(2, "MH03P0124", 500.0, 20.0));
		vehicles.add(new Bike(3, "MH03P0125", 500.0, 20.0));
		vehicles.add(new Car(4, "MH03P0126", 1000.0, 50.0));
		vehicles.add(new Car(5, "MH03P0127", 1000.0, 50.0));
		
		return vehicles;
	}
}
