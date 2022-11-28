package model;
import model.enums.ReservationType;

public class Bill {
	private Reservation reservation;
	private boolean isPaid;
	private double amount;
	
	public Bill(Reservation reservation) {
		this.reservation = reservation;
		this.isPaid = false;
		this.amount = 0.0;
	}
	
	public double computeBillAmount() {
		if(reservation.getReservationType() == ReservationType.HOURLY) {
			// Compute actual number of hours vehicle was booked for.
			amount = reservation.getVehicle().getHourlyCost() * 1; 
		}
		else if(reservation.getReservationType() == ReservationType.DAILY) {
			// Compute actual number of days vehicle was booked for.
			amount = reservation.getVehicle().getDailyCost() * 1;
		}
		return amount;
	}

	public boolean getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
}
