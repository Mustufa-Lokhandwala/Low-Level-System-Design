package model.payment;

import model.Booking;

public interface Payment {
    public void makePayment(Booking booking);
}
