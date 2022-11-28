package strategy;

import model.Calendar;
import model.MeetingRoom;

import java.util.List;
import java.util.Map;

public interface MeetingRoomBookingStrategy {
    public MeetingRoom getAvailableRoom(List<MeetingRoom> meetingRooms, Map<MeetingRoom, Calendar> meetingRoomToCalendarMap,
                                        int startTime, int endTime, int capacity);
}
