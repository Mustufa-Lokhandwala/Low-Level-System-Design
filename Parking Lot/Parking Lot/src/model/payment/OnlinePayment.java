package model.payment;

import model.Ticket;

public class OnlinePayment implements Payment {


    @Override
    public void makePayment(Ticket ticket) {
        // Do cost computation here..
        double timeSpent = System.currentTimeMillis() - ticket.getEntryTime();
        double amountToPay = timeSpent * ticket.getParkingSpot().getPrice();

        // Do online payment processing here.
        System.out.println("Online Payment done for " + ticket);

        // Set payment status in the ticket.
        ticket.setPaid(true);
    }
}
