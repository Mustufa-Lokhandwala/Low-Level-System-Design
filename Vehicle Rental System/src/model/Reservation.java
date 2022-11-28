package model;
import java.util.Date;
import java.util.Objects;

import model.enums.ReservationStatus;
import model.enums.ReservationType;

public class Reservation {
	private int reservationId;
	private User user;
	private Vehicle vehicle;
	private Date bookingDate;
	private Date bookedFromDate;
	private Date bookedToDate;
	private long bookedFromTime;
	private long bookedToTime;
	private Location pickupLocation;
	private Location dropoffLocation;
	private ReservationStatus reservationStatus;
	private ReservationType reservationType;
	
	public Reservation(int reservationId, User user, Vehicle vehicle, Date bookingDate,Date bookedFromDate, 
			           Date bookedToDate, long bookedFromTime, long bookedToTime, Location pickupLocation,
			           Location dropoffLocation, ReservationType reservationType) {
		this.reservationId = reservationId;
		this.user = user;
		this.vehicle = vehicle;
		this.bookingDate = bookingDate;
		this.bookedFromDate = bookedFromDate;
		this.bookedToDate = bookedToDate;
		this.bookedFromTime = bookedFromTime;
		this.bookedToTime = bookedToTime;
		this.pickupLocation = pickupLocation;
		this.dropoffLocation = dropoffLocation;
		this.reservationType = reservationType;
		
		// can add logic here as per bookingDate, bookedFromDate..
		this.reservationStatus = ReservationStatus.SCHEDULED;
	}

	public void setReservationStatus(ReservationStatus reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public int getReservationId() {
		return reservationId;
	}

	public User getUser() {
		return user;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public Date getBookedFromDate() {
		return bookedFromDate;
	}

	public Date getBookedToDate() {
		return bookedToDate;
	}

	public long getBookedFromTime() {
		return bookedFromTime;
	}

	public long getBookedToTime() {
		return bookedToTime;
	}

	public Location getPickupLocation() {
		return pickupLocation;
	}

	public Location getDropoffLocation() {
		return dropoffLocation;
	}

	public ReservationStatus getReservationStatus() {
		return reservationStatus;
	}

	public ReservationType getReservationType() {
		return reservationType;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(bookedFromDate, other.bookedFromDate) && bookedFromTime == other.bookedFromTime
				&& Objects.equals(bookedToDate, other.bookedToDate) && bookedToTime == other.bookedToTime
				&& Objects.equals(bookingDate, other.bookingDate)
				&& Objects.equals(dropoffLocation, other.dropoffLocation)
				&& Objects.equals(pickupLocation, other.pickupLocation) && reservationId == other.reservationId
				&& reservationStatus == other.reservationStatus && reservationType == other.reservationType
				&& Objects.equals(user, other.user) && Objects.equals(vehicle, other.vehicle);
	}
}
