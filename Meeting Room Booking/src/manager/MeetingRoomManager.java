package manager;

import model.Calendar;
import model.MeetingRoom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetingRoomManager {
    private List<MeetingRoom> meetingRooms;
    private Map<MeetingRoom, Calendar> meetingRoomToCalendarMap;

    public MeetingRoomManager() {
        this.meetingRooms = new ArrayList<>();
        this.meetingRoomToCalendarMap = new HashMap<>();
    }

    public void addRoom(MeetingRoom meetingRoom) {
        this.meetingRooms.add(meetingRoom);
        this.meetingRoomToCalendarMap.put(meetingRoom, new Calendar());
    }

    public void removeRoom(MeetingRoom meetingRoom) {
        this.meetingRooms.remove(meetingRoom);
        this.meetingRoomToCalendarMap.remove(meetingRoom);
    }

    public void updateCapacityForRoom(MeetingRoom meetingRoom, int newCapacity) {
        meetingRoom.setCapacity(newCapacity);
    }

    public List<MeetingRoom> getMeetingRooms() {
        return meetingRooms;
    }

    public Map<MeetingRoom, Calendar> getMeetingRoomToCalendarMap() {
        return meetingRoomToCalendarMap;
    }
}
