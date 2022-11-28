package model;

import java.util.ArrayList;
import java.util.List;

public class Show {
    private int id;
    private Movie movie;
    private Screen screen;
    private int startTime;
    private List<Seat> bookedSeats;

    public Show(int id, Movie movie, Screen screen, int startTime) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.bookedSeats = new ArrayList<>();
    }

    public void bookSeats(List<Seat> seats) {
        for(Seat seat : seats)
            bookedSeats.add(seat);
    }

    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public int getStartTime() {
        return startTime;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

}
