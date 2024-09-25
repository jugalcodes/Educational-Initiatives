// Filename: SmartOffice.java

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SmartOffice {
    private static SmartOffice instance;
    private Map<String, User> users = new HashMap<>();
    private List<Room> rooms = new ArrayList<>();
    private User currentUser;

    private SmartOffice() {
        // Admin user for setup
        users.put("admin", new User("admin", "password", true));
    }

    public static SmartOffice getInstance() {
        if (instance == null) {
            instance = new SmartOffice();
        }
        return instance;
    }

    public void registerUser(String username, String password, boolean isAdmin) {
        users.put(username, new User(username, password, isAdmin));
    }

    public boolean loginUser(String username, String password) {
        if (users.containsKey(username) && users.get(username).validatePassword(password)) {
            currentUser = users.get(username);
            System.out.println("User " + username + " logged in successfully.");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    public void logout() {
        System.out.println("User " + currentUser.getUsername() + " logged out.");
        currentUser = null;
    }

    public void configureRooms(int roomCount) {
        if (!currentUser.isAdmin()) {
            System.out.println("Access denied. Only admin users can configure rooms.");
            return;
        }

        rooms.clear();
        for (int i = 1; i <= roomCount; i++) {
            rooms.add(new Room(i));
        }
        System.out.println("Office configured with " + roomCount + " meeting rooms.");
    }

    public Room getRoom(int roomNumber) {
        if (roomNumber <= 0 || roomNumber > rooms.size()) {
            System.out.println("Invalid room number. Please enter a valid room number.");
            return null;
        }
        return rooms.get(roomNumber - 1);
    }

    public void displayRoomStatistics(int roomNumber) {
        Room room = getRoom(roomNumber);
        if (room != null) {
            room.displayStatistics();
        }
    }

    public boolean isAdmin() {
        return currentUser != null && currentUser.isAdmin();
    }
}
