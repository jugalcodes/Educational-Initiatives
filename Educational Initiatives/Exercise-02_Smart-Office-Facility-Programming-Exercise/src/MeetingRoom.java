import java.util.Timer;
import java.util.TimerTask;

public class MeetingRoom implements OccupancyObserver {
    private int roomNumber;
    private int maxCapacity;
    private boolean isBooked;
    private boolean isOccupied;
    private Timer occupancyTimer;

    public MeetingRoom(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
        this.isOccupied = false;
    }

    public void setMaxCapacity(int capacity) {
        if (capacity <= 0) {
            System.out.println("Invalid capacity. Please enter a valid positive number.");
        } else {
            this.maxCapacity = capacity;
            System.out.println("Room " + roomNumber + " maximum capacity set to " + capacity + ".");
        }
    }

    public void bookRoom(String startTime, int duration) {
        if (isBooked) {
            System.out.println("Room " + roomNumber + " is already booked during this time.");
        } else {
            isBooked = true;
            System.out.println("Room " + roomNumber + " booked from " + startTime + " for " + duration + " minutes.");
        }
    }

    public void cancelBooking() {
        if (!isBooked) {
            System.out.println("Room " + roomNumber + " is not booked. Cannot cancel booking.");
        } else {
            isBooked = false;
            System.out.println("Booking for Room " + roomNumber + " cancelled successfully.");
        }
    }

    public void updateOccupancy(int occupants) {
        if (occupants >= 2) {
            isOccupied = true;
            System.out.println("Room " + roomNumber + " is now occupied by " + occupants + " persons. AC and lights turned on.");
        } else if (occupants == 0) {
            isOccupied = false;
            System.out.println("Room " + roomNumber + " is now unoccupied. AC and lights turned off.");
            startReleaseTimer();
        } else {
            System.out.println("Room " + roomNumber + " occupancy insufficient to mark as occupied.");
        }
    }

    private void startReleaseTimer() {
        occupancyTimer = new Timer();
        occupancyTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!isOccupied && isBooked) {
                    cancelBooking();
                }
            }
        }, 5 * 60 * 1000); // 5-minute delay
    }

    @Override
    public void onOccupancyChange(int occupants) {
        updateOccupancy(occupants);
    }
}
