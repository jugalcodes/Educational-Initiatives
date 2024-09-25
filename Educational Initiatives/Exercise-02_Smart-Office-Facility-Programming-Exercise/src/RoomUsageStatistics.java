// Filename: RoomUsageStatistics.java

public class RoomUsageStatistics {
    private int totalBookings = 0;
    private int totalOccupancyTime = 0; // in minutes
    private int occupancyCount = 0;

    public void incrementBookings() {
        totalBookings++;
    }

    public void addOccupancyTime(int timeInMinutes) {
        totalOccupancyTime += timeInMinutes;
        occupancyCount++;
    }

    public void displayStatistics(int roomNumber) {
        System.out.println("Room " + roomNumber + " Usage Stats:");
        System.out.println("Total Bookings: " + totalBookings);
        System.out.println("Total Occupancy Time: " + totalOccupancyTime + " minutes");
        System.out.println("Average Occupancy Time: " + (occupancyCount == 0 ? 0 : totalOccupancyTime / occupancyCount) + " minutes");
    }
}
