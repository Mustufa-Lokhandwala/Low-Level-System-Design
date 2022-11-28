package model;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private int id;
    private Address address;
    private List<Screen> screens;
    private List<Show> shows;
    private List<Booking> bookings;

    public Theatre(int id, Address address) {
        this.id = id;
        this.address = address;
        this.screens = new ArrayList<>();
        this.shows = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public void addScreen(Screen screen) {
        screens.add(screen);
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public int getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public List<Show> getShows() {
        return shows;
    }
}
