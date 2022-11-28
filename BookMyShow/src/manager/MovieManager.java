package manager;

import model.enums.City;
import model.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieManager {
    private Map<City, List<Movie>> cityToMoviesMap;
    private List<Movie> allMovies;

    public MovieManager() {
        this.cityToMoviesMap = new HashMap<>();
        this.allMovies = new ArrayList<>();
    }

    public void addMovie(Movie movie, City city) {
        if(!cityToMoviesMap.containsKey(city))
            cityToMoviesMap.put(city, new ArrayList<>());
        cityToMoviesMap.get(city).add(movie);
        allMovies.add(movie);
    }

    public List<Movie> getMoviesByCity(City city) {
        return cityToMoviesMap.get(city);
    }
}
