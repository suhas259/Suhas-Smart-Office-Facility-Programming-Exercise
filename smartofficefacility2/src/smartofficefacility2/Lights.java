package smartofficefacility2;

public class Lights implements RoomObserver {
	private boolean isOn = false;

    @Override
    public void update(int occupancy) {
        if (occupancy > 0) {
            isOn = true;
            System.out.println("Lights are turned on.");
        } else {
            isOn = false;
            System.out.println("Lights are turned off.");
        }
    }

}
