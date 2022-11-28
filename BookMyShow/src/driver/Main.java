package driver;

import model.*;
import model.enums.City;
import model.enums.SeatCategory;
import model.payment.OnlinePayment;
import service.BookMyShowService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        BookMyShowService service = new BookMyShowService();
        initialize(service);

        // 1. User comes.
        User user = new User(1, "Mustafa");

        // 2. User searches for all movies in a particular city.
        List<Movie> movies = service.getMoviesByCity(City.PUNE);

        // 3. Say user wants to see movie "Rocketry". He/She finds all shows for this movie in the city.
        Map<Theatre, List<Show>> showsTheatreWise = service.getShowsTheatreWise("Rocketry", City.PUNE);

        // 4. User wants to take look at available seats for a particular show.
        Map.Entry<Theatre, List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        Theatre theatre = entry.getKey();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);
        List<Seat> availableSeats = service.getAvailableSeats(interestedShow);

        // 5. User wants to make booking for particular seats in particular show in particular theatre.
        List<Seat> seatsToBook = new ArrayList<>();
        seatsToBook.add(availableSeats.get(47));
        seatsToBook.add(availableSeats.get(48));
        seatsToBook.add(availableSeats.get(99));
        Booking booking1 = service.makeBooking(user, theatre, interestedShow, seatsToBook);
        Booking booking2 = service.makeBooking(user, theatre, interestedShow, seatsToBook);

        // 6. Make Payment
        OnlinePayment payment = new OnlinePayment();
        payment.makePayment(booking1);
    }

    private static void initialize(BookMyShowService service) {
        Movie movie1 = new Movie(1, "Brahmastra", 170);
        Movie movie2 = new Movie(2, "Rocketry", 150);

        service.addMovie(movie1, City.PUNE);
        service.addMovie(movie1, City.BANGALORE);
        service.addMovie(movie2, City.PUNE);
        service.addMovie(movie2, City.BANGALORE);

        List<Theatre> theatres = new ArrayList<>();

        Theatre theatre1 = new Theatre(1, new Address(City.PUNE, "Maharashtra", 333453, ""));
        Screen screen1 = new Screen(1, createSeats());
        Screen screen2 = new Screen(2, createSeats());
        theatre1.addScreen(screen1);
        theatre1.addScreen(screen2);
        theatre1.addShow(new Show(1, movie1, screen1, 1300));
        theatre1.addShow(new Show(2, movie2, screen2, 1300));
        theatre1.addShow(new Show(3, movie1, screen1, 1600));
        theatre1.addShow(new Show(4, movie2, screen2, 1600));

        Theatre theatre2 = new Theatre(2, new Address(City.PUNE, "Maharashtra", 333453, ""));
        theatre2.addScreen(screen1);
        theatre2.addScreen(screen2);
        theatre2.addShow(new Show(5, movie1, screen1, 1300));
        theatre2.addShow(new Show(6, movie2, screen2, 1300));
        theatre2.addShow(new Show(7, movie1, screen1, 1600));
        theatre2.addShow(new Show(8, movie2, screen2, 1600));

        service.addTheatre(theatre1);
        service.addTheatre(theatre2);
    }

    private static List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();

        for(int seatNo = 1; seatNo <= 30; seatNo++)
            seats.add(new Seat(seatNo, SeatCategory.SILVER, 100));

        for(int seatNo = 31; seatNo <= 70; seatNo++)
            seats.add(new Seat(seatNo, SeatCategory.GOLD, 150));

        for(int seatNo = 71; seatNo <= 100; seatNo++)
            seats.add(new Seat(seatNo, SeatCategory.PLATINUM, 200));

        return seats;
    }
}
