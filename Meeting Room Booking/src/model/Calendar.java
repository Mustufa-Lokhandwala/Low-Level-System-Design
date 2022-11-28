package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calendar {
    private List<Interval> bookedIntervals;

    public Calendar() {
        this.bookedIntervals = new ArrayList<Interval>();
    }

    public List<Interval> getBookedIntervals() {
        return bookedIntervals;
    }

    public void addInterval(Interval interval) {
        this.bookedIntervals.add(interval);
        Collections.sort(bookedIntervals);
    }

    @Override
    public String toString() {
        return "model.Calendar{" +
                "bookedIntervals=" + bookedIntervals +
                '}';
    }
}
