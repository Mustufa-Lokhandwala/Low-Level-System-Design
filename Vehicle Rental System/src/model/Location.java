package model;

import java.util.Objects;

public class Location {
	private int locationId;
	private String address;
	private String city;
	private String state;
	private int pincode;
	
	public Location(int locationId, String address, String city, String state, int pincode) {
		this.locationId = locationId;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public int getLocationId() {
		return locationId;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public int getPincode() {
		return pincode;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& locationId == other.locationId && pincode == other.pincode && Objects.equals(state, other.state);
	}
}
