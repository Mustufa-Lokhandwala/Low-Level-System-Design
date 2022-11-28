package manager;

import model.Show;
import model.enums.City;
import model.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreManager {
    private Map<City, List<Theatre>> cityToTheatresMap;
    private List<Theatre> allTheatres;

    public TheatreManager() {
        this.cityToTheatresMap = new HashMap<>();
        this.allTheatres = new ArrayList<>();
    }

    public void addTheatre(Theatre theatre) {
        City city = theatre.getAddress().getCity();

        if(!cityToTheatresMap.containsKey(city))
            cityToTheatresMap.put(city, new ArrayList<>());
        cityToTheatresMap.get(city).add(theatre);

        allTheatres.add(theatre);
    }

    public Map<Theatre, List<Show>> getShowsTheatreWise(String movieName, City city) {
        Map<Theatre, List<Show>> showsTheatreWise = new HashMap<>();
        List<Theatre> theatresByCity = cityToTheatresMap.get(city);
        for(Theatre theatre : theatresByCity) {
            for(Show show : theatre.getShows()) {
                if(show.getMovie().getName() == movieName) {
                    if(!showsTheatreWise.containsKey(theatre))
                        showsTheatreWise.put(theatre, new ArrayList<>());
                    showsTheatreWise.get(theatre).add(show);
                }
            }
        }
        return showsTheatreWise;
    }
}
