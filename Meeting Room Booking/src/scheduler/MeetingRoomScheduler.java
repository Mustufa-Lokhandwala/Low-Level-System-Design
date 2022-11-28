package scheduler;

import manager.MeetingRoomManager;
import model.Interval;
import model.MeetingRoom;
import strategy.MeetingRoomBookingStrategy;

public class MeetingRoomScheduler {
    private MeetingRoomManager meetingRoomManager;
    private MeetingRoomBookingStrategy meetingRoomBookingStrategy;

    public MeetingRoomScheduler(MeetingRoomManager meetingRoomManager, MeetingRoomBookingStrategy meetingRoomBookingStrategy) {
        this.meetingRoomManager = meetingRoomManager;
        this.meetingRoomBookingStrategy = meetingRoomBookingStrategy;
    }

    public MeetingRoom bookRoom(int startTime, int endTime, int capacity) {
        MeetingRoom meetingRoom = meetingRoomBookingStrategy.getAvailableRoom(meetingRoomManager.getMeetingRooms(),
                                                                              meetingRoomManager.getMeetingRoomToCalendarMap(),
                                                                              startTime,
                                                                              endTime,
                                                                              capacity);

        if(meetingRoom != null) // Update calendar for this meeting room
            meetingRoomManager.getMeetingRoomToCalendarMap().get(meetingRoom).addInterval(new Interval(startTime, endTime));

        return meetingRoom;
    }
}
