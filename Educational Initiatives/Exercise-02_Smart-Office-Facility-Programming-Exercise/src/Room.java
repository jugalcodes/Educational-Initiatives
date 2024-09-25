// Filename: Room.java

import java.util.Timer;
import java.util.TimerTask;

public class Room {
    private boolean isBooked = false;
    private boolean isOccupied = false;
    private boolean acOn = false;
    private boolean lightsOn = false;
    private Timer releaseTimer;
    private int roomNumber;
    private RoomUsageStatistics statistics;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.statistics = new RoomUsageStatistics();
    }

    public boolean isBooked() {
        return isBooked;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void book(String username, String startTime, int duration) {
        if (isBooked) {
            System.out.println("Room " + roomNumber + " is already booked during this time. Cannot book.");
        } else {
            isBooked = true;
            System.out.println("Room " + roomNumber + " booked by " + username + " from " + startTime + " for " + duration + " minutes.");
            statistics.incrementBookings();
            startReleaseTimer(username, duration);
        }
    }

    public void cancelBooking() {
        if (isBooked) {
            isBooked = false;
            System.out.println("Booking for Room " + roomNumber + " cancelled successfully.");
        } else {
            System.out.println("Room " + roomNumber + " is not booked. Cannot cancel booking.");
        }
    }

    public void setOccupancy(int occupants) {
        if (occupants >= 2) {
            isOccupied = true;
            acOn = true;
            lightsOn = true;
            System.out.println("Room " + roomNumber + " is now occupied by " + occupants + " persons. AC and lights turned on.");
            statistics.addOccupancyTime(60); // Assume 1 hour for simplicity
        } else {
            isOccupied = false;
            acOn = false;
            lightsOn = false;
            System.out.println("Room " + roomNumber + " is now unoccupied. AC and lights turned off.");
        }
    }

    public void displayStatistics() {
        statistics.displayStatistics(roomNumber);
    }

    private void startReleaseTimer(String username, int delayMinutes) {
        if (releaseTimer != null) {
            releaseTimer.cancel();
        }

        releaseTimer = new Timer();
        releaseTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!isOccupied) {
                    releaseBooking(username);
                }
            }
        }, delayMinutes * 1000L);
    }

    private void releaseBooking(String username) {
        isBooked = false;
        System.out.println("Room " + roomNumber + " booking was automatically released due to no occupancy. AC and lights off.");
        sendNotification(username);
    }

    private void sendNotification(String username) {
        // Simulated email or SMS notification
        System.out.println("Notification sent to " + username + ": Your booking for Room " + roomNumber + " was released automatically.");
    }
}
