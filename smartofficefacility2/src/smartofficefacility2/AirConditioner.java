package smartofficefacility2;

public class AirConditioner implements RoomObserver{
	private boolean isOn = false;

    @Override
    public void update(int occupancy) {
        if (occupancy > 0) {
            isOn = true;
            System.out.println("Air Conditioner is turned on.");
        } else {
            isOn = false;
            System.out.println("Air Conditioner is turned off.");
        }
    }
}
