package model.payment;

import model.Ticket;

public class CashPayment implements Payment {
    @Override
    public void makePayment(Ticket ticket) {
        // Do cost computation here..
        double timeSpent = System.currentTimeMillis() - ticket.getEntryTime();
        double amountToPay = timeSpent * ticket.getParkingSpot().getPrice();

        // Do cash payment processing here.
        System.out.println("Cash Payment done for " + ticket);

        // Set payment status in the ticket.
        ticket.setPaid(true);
    }
}
