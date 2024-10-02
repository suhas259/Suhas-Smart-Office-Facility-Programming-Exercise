package smartofficefacility2;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OfficeConfig {
	private Map<Integer, Room> rooms;

    public OfficeConfig() {
        rooms = new HashMap<>();
    }

    public void configureRooms(int roomCount) {
    	for (int i = 1; i <= roomCount; i++) {
            System.out.print("Enter capacity for Room " + i + ": ");
            int capacity = new Scanner(System.in).nextInt(); // Getting capacity for each room
            rooms.put(i, new Room("Room " + i, capacity));
        }
        System.out.println("Office configured with " + roomCount + " meeting rooms.");
    }

    public Room getRoom(int roomNumber) {
        return rooms.get(roomNumber);
    }

    public void printRoomStatistics() {
        for (Room room : rooms.values()) {
            System.out.println(room.getName() + " | Occupied: " + room.getOccupantCount() + 
                               " | Booked: " + room.isBooked());
        }
    }

}
