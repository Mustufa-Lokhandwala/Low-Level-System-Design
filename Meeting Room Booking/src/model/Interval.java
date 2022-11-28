package model;

public class Interval implements Comparable<Interval> {
    private int startTime;
    private int endTime;

    public Interval(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Interval o) {
        if(o == null)
            return -1;
        if(o.startTime == this.startTime)
            return Integer.compare(this.endTime, o.endTime);
        return Integer.compare(this.startTime, o.startTime);
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "model.Interval{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
