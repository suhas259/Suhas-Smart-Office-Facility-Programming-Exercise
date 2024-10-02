package smartofficefacility2;
import java.util.Timer;
import java.util.TimerTask;

public class Room {
	private String name;
    private int capacity;
    private boolean isBooked;
    private long bookedUntil;
    private int occupantCount;
    private Timer timer;

    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.isBooked = false;
        this.occupantCount = 0;
        this.timer = new Timer();
    }

    public void bookRoom(String startTime, int duration) {
        if (!isBooked) {
            isBooked = true;
            bookedUntil = System.currentTimeMillis() + duration * 60 * 1000; // duration in minutes
            System.out.println(name + " booked from " + startTime + " for " + duration + " minutes.");
            startAutoRelease();
        } else {
            System.out.println(name + " is already booked.");
        }
    }

    public void cancelBooking() {
        if (isBooked) {
            isBooked = false;
            occupantCount = 0;
            timer.cancel();
            System.out.println(name + " booking canceled.");
        } else {
            System.out.println(name + " is not booked.");
        }
    }

    public void addOccupant(int count) {
        occupantCount += count;
        System.out.println(name + " now occupied by " + occupantCount + " persons.");
        if (occupantCount >= 2) {
            System.out.println("Room " + name + " is occupied. AC and lights turned on.");
        }
    }

    public void removeOccupant(int count) {
        occupantCount -= count;
        if (occupantCount < 0) occupantCount = 0;
        System.out.println(name + " now occupied by " + occupantCount + " persons.");
        if (occupantCount < 2) {
            System.out.println("Room " + name + " is unoccupied. AC and lights turned off.");
        }
    }

    public void checkAutoRelease() {
        if (isBooked && System.currentTimeMillis() > bookedUntil) {
            cancelBooking();
            System.out.println(name + " booking released due to inactivity.");
        }
    }

    private void startAutoRelease() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                checkAutoRelease();
            }
        }, 300000); // Check every 5 minutes
    }

    public boolean isBooked() {
        return isBooked;
    }

    public String getName() {
        return name;
    }

    public int getOccupantCount() {
        return occupantCount;
    }

    public long getBookedUntil() {
        return bookedUntil;
    }

}
