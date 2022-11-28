import manager.MeetingRoomManager;
import model.MeetingRoom;
import scheduler.MeetingRoomScheduler;
import strategy.DefaultMeetingRoomBookingStrategy;

public class Driver {
    public static void main(String[] args) {
        MeetingRoom r1 = new MeetingRoom("1", "room1", 3);
        MeetingRoom r2 = new MeetingRoom("2", "room2", 4);
        MeetingRoom r3 = new MeetingRoom("3", "room3", 5);
        MeetingRoom r4 = new MeetingRoom("4", "room4", 2);

        MeetingRoomManager meetingRoomManager = new MeetingRoomManager();
        meetingRoomManager.addRoom(r1);
        meetingRoomManager.addRoom(r2);
        meetingRoomManager.addRoom(r3);
        meetingRoomManager.addRoom(r4);

        MeetingRoomScheduler meetingRoomScheduler = new MeetingRoomScheduler(meetingRoomManager, new DefaultMeetingRoomBookingStrategy());
        makeBooking(meetingRoomScheduler, 1, 4, 3);
        makeBooking(meetingRoomScheduler, 4, 6, 3);
        makeBooking(meetingRoomScheduler, 5, 7, 3);
        makeBooking(meetingRoomScheduler, 5, 7, 6);
    }

    private static void makeBooking(MeetingRoomScheduler meetingRoomScheduler, int startTime, int endTime, int capacity) {
        System.out.println("Request -- startTime: " + startTime + ", endTime: " + endTime + ", capacity: " + capacity);
        MeetingRoom bookedRoom = meetingRoomScheduler.bookRoom(startTime, endTime, capacity);
        if(bookedRoom == null)
            System.out.println("Response -- Could not book room\n");
        else
            System.out.println("Response -- " + bookedRoom + "\n");
    }
}
