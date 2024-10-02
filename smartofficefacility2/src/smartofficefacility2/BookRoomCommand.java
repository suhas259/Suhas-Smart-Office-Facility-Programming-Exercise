package smartofficefacility2;

import model.Room;


public class BookRoomCommand implements RoomCommand {
	private Room room;
    private String startTime;
    private int duration;

    public BookRoomCommand(Room room, String startTime, int duration) {
        this.room = room;
        this.startTime = startTime;
        this.duration = duration;
    }

    @Override
    public void execute() {
        room.bookRoom(startTime, duration);
    }

}
