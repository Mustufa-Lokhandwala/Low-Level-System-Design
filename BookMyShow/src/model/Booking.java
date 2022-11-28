package model;

import java.util.List;

public class Booking {
    private User user;
    private Show show;
    private List<Seat> bookedSeats;
    private boolean isPaid;

    public Booking(User user, Show show, List<Seat> bookedSeats) {
        this.user = user;
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.isPaid = false;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public User getUser() {
        return user;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }
}
