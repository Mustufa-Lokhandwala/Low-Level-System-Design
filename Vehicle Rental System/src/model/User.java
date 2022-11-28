package model;

public class User {
	private int userId;
	private String name;
	private String drivingLicense;
	
	public User(int userId, String name, String drivingLicense) {
		this.userId = userId;
		this.name = name;
		this.drivingLicense = drivingLicense;
	}

	public int getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getDrivingLicense() {
		return drivingLicense;
	}
}
