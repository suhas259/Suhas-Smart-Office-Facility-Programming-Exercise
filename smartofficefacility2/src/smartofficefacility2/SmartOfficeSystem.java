package smartofficefacility2;

import command.BookRoomCommand;
import command.CancelBookingCommand;
import model.OfficeConfig;
import model.Room;
import model.UserManager;

import java.util.Scanner;

public class SmartOfficeSystem {
	
	private static OfficeConfig config = new OfficeConfig();
    private static UserManager userManager = new UserManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Smart Office System");
        if (!login(scanner)) {
            System.out.println("Authentication failed. Exiting.");
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println("1. Configure Rooms\n2. Book Room\n3. Cancel Booking\n4. Room Statistics\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Configure rooms
                    System.out.print("Enter number of rooms: ");
                    int roomCount = scanner.nextInt();
                    config.configureRooms(roomCount);
                    break;

                case 2: // Book a room
                    System.out.print("Enter room number to book: ");
                    int roomNumber = scanner.nextInt();
                    Room roomToBook = config.getRoom(roomNumber);
                    if (roomToBook != null) {
                        System.out.print("Enter start time (HH:MM): ");
                        String startTime = scanner.next();
                        System.out.print("Enter duration (minutes): ");
                        int duration = scanner.nextInt();
                        RoomCommand bookCommand = new BookRoomCommand(roomToBook, startTime, duration);
                        bookCommand.execute();
                    } else {
                        System.out.println("Invalid room number.");
                    }
                    break;

                case 3: // Cancel a booking
                    System.out.print("Enter room number to cancel: ");
                    roomNumber = scanner.nextInt();
                    Room roomToCancel = config.getRoom(roomNumber);
                    if (roomToCancel != null) {
                        RoomCommand cancelCommand = new CancelBookingCommand(roomToCancel);
                        cancelCommand.execute();
                    } else {
                        System.out.println("Invalid room number.");
                    }
                    break;

                case 4: // Room statistics
                    config.printRoomStatistics();
                    break;

                case 5: // Exit
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static boolean login(Scanner scanner) {
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();
        return userManager.authenticate(username, password);
    }
	
	

}
