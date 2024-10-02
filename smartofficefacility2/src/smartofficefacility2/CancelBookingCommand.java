package smartofficefacility2;

import model.Room;

public class CancelBookingCommand implements RoomCommand {
	private Room room;

    public CancelBookingCommand(Room room) {
        this.room = room;
    }

    @Override
    public void execute() {
        room.cancelBooking();
    }

}
