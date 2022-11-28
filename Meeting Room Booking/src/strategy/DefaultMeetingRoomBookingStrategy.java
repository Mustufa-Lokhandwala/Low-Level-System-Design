package strategy;

import model.Calendar;
import model.Interval;
import model.MeetingRoom;

import java.util.List;
import java.util.Map;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class DefaultMeetingRoomBookingStrategy implements MeetingRoomBookingStrategy {
    @Override
    public MeetingRoom getAvailableRoom(List<MeetingRoom> meetingRooms, Map<MeetingRoom, Calendar> meetingRoomToCalendarMap,
                                        int startTime, int endTime, int capacity) {
        for(MeetingRoom meetingRoom : meetingRooms) {
            // Check if this meeting room is available for booking.
            if(canBook(meetingRoom, meetingRoomToCalendarMap.get(meetingRoom), startTime, endTime, capacity))
                return meetingRoom;
        }
        return null;
    }

    private boolean canBook(MeetingRoom meetingRoom, Calendar calendar, int startTime, int endTime, int capacity) {
        if(meetingRoom.getCapacity() < capacity)
            return false;

        List<Interval> bookedIntervals = calendar.getBookedIntervals();
        for(Interval interval : bookedIntervals) {
            int s1 = interval.getStartTime();
            int e1 = interval.getEndTime();
            // Check if there is an overlap.
            if((max(e1, endTime) - min(s1, startTime)) < (e1-s1 + endTime-startTime)) {
                return false;
            }
        }
        return true;
    }
}
