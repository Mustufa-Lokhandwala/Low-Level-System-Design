package service;

import manager.MovieManager;
import manager.TheatreManager;
import model.*;
import model.enums.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShowService {
    private MovieManager movieManager;
    private TheatreManager theatreManager;

    public BookMyShowService() {
        this.movieManager = new MovieManager();
        this.theatreManager = new TheatreManager();
    }

    public void addMovie(Movie movie, City city) {
        movieManager.addMovie(movie, city);
    }

    public void addTheatre(Theatre theatre) {
        theatreManager.addTheatre(theatre);
    }

    public List<Movie> getMoviesByCity(City city) {
        return movieManager.getMoviesByCity(city);
    }

    public Map<Theatre, List<Show>> getShowsTheatreWise(String movieName, City city) {
        return theatreManager.getShowsTheatreWise(movieName, city);
    }

    public List<Seat> getAvailableSeats(Show show) {
        List<Seat> totalSeats = show.getScreen().getSeats();
        List<Seat> bookedSeats = show.getBookedSeats();
        List<Seat> availableSeats = new ArrayList<>();

        for(Seat seat : totalSeats) {
            if(!bookedSeats.contains(seat))
                availableSeats.add(seat);
        }
        return availableSeats;
    }

    public Booking makeBooking(User user, Theatre theatre, Show show, List<Seat> seats) {
        boolean canBook = true;
        for(Seat seat : seats) {
            if(show.getBookedSeats().contains(seat)) {
                System.out.println("Seat no { " + seat.getId() + " } is already booked. Please select another seat.");
                canBook = false;
            }
        }
        if(!canBook)
            return null;

        show.bookSeats(seats);
        Booking booking = new Booking(user, show, seats);
        theatre.addBooking(booking);

        return booking;
    }
}
