import java.util.Scanner;

public class SmartOfficeApp {

    public static void main(String[] args) {
        OfficeConfiguration office = OfficeConfiguration.getInstance();
        Sensor sensor = new Sensor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Configure number of rooms:");
        int numRooms = scanner.nextInt();
        office.configureRooms(numRooms);

        for (int i = 1; i <= numRooms; i++) {
            MeetingRoom room = office.getRoom(i);  // Ensure you are getting a MeetingRoom
            sensor.registerObserver(room);
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("Enter command (1. Book, 2. Cancel, 3. Add Occupant, 4. Exit): ");
            int command = scanner.nextInt();

            switch (command) {
                case 1: // Booking a room
                    System.out.println("Enter room number, start time, and duration:");
                    int roomNumber = scanner.nextInt();
                    String startTime = scanner.next();
                    int duration = scanner.nextInt();
                    MeetingRoom roomToBook = office.getRoom(roomNumber); // Use updated MeetingRoom class
                    Command bookRoom = new BookRoomCommand(roomToBook, startTime, duration);
                    bookRoom.execute();
                    break;

                case 2: // Cancelling a booking
                    System.out.println("Enter room number to cancel:");
                    roomNumber = scanner.nextInt();
                    MeetingRoom roomToCancel = office.getRoom(roomNumber); // Use updated MeetingRoom class
                    Command cancelRoom = new CancelRoomCommand(roomToCancel);
                    cancelRoom.execute();
                    break;

                case 3: // Adding occupants
                    System.out.println("Enter room number and occupants:");
                    roomNumber = scanner.nextInt();
                    int occupants = scanner.nextInt();
                    sensor.detectOccupancyChange(roomNumber, occupants);
                    break;

                case 4: // Exit command
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid command");
            }
        }

        scanner.close(); // It's a good practice to close the scanner
    }
}
