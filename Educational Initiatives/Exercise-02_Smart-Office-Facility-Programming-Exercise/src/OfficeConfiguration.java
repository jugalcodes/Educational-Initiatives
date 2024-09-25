import java.util.HashMap;
import java.util.Map;

public class OfficeConfiguration {
    private static OfficeConfiguration instance;
    private Map<Integer, MeetingRoom> rooms;

    private OfficeConfiguration() {
        rooms = new HashMap<>();
    }

    public static OfficeConfiguration getInstance() {
        if (instance == null) {
            instance = new OfficeConfiguration();
        }
        return instance;
    }

    public void configureRooms(int numRooms) {
        for (int i = 1; i <= numRooms; i++) {
            rooms.put(i, new MeetingRoom(i));
        }
        System.out.println("Office configured with " + numRooms + " meeting rooms.");
    }

    public MeetingRoom getRoom(int roomNumber) {
        return rooms.get(roomNumber);
    }
}
