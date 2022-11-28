package model.payment;

import model.Booking;
import model.Seat;

import java.util.List;

public class CashPayment implements Payment {
    @Override
    public void makePayment(Booking booking) {
        // Do cost computation.
        int amountToPay = 0;
        for(Seat seat : booking.getBookedSeats()) {
            amountToPay += seat.getPrice();
        }

        // Do cash payment processing.
        System.out.println("Cash Payment of { Rs " + amountToPay + " } done for " + booking);

        // Update payment status in the booking.
        booking.setPaid(true);
    }
}
