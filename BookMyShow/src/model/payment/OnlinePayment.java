package model.payment;

import model.Booking;
import model.Seat;

import java.util.List;

public class OnlinePayment implements Payment {
    @Override
    public void makePayment(Booking booking) {
        // Do cost computation.
        int amountToPay = 0;
        for(Seat seat : booking.getBookedSeats()) {
            amountToPay += seat.getPrice();
        }

        // Do online payment processing.
        System.out.println("Online Payment of { Rs " + amountToPay + " } done for " + booking);

        // Update payment status in the booking.
        booking.setPaid(true);
    }
}
