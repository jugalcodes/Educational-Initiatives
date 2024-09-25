import java.util.ArrayList;
import java.util.List;

public class Sensor {
    private List<OccupancyObserver> observers = new ArrayList<>();

    public void registerObserver(OccupancyObserver observer) {
        observers.add(observer);
    }

    public void detectOccupancyChange(int roomNumber, int occupants) {
        for (OccupancyObserver observer : observers) {
            observer.onOccupancyChange(occupants);
        }
    }
}
