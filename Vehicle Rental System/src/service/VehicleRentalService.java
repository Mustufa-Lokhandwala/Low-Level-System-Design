package service;
import java.util.ArrayList;
import java.util.List;

import model.Location;
import model.Store;
import model.User;

public class VehicleRentalService {
	private List<User> users;
	private List<Store> stores;
	
	public VehicleRentalService() {
		users = new ArrayList<User>();
		stores = new ArrayList<Store>();
	}
	
	public List<Store> getStores(Location location) {
		List<Store> stores = new ArrayList<>();
		for(Store store : this.stores) {
			if(store.getLocation().equals(location)) {
				stores.add(store);
			}
		}
		return stores;
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void addStore(Store store) {
		stores.add(store);
	}
	
	public void removeUser(User user) {
		users.remove(user);
	}
	
	public void removeStore(Store store) {
		stores.remove(store);
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}
}
