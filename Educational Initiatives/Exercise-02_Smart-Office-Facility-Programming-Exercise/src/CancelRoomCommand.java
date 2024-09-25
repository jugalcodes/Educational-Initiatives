public class CancelRoomCommand implements Command {
    private MeetingRoom room;

    public CancelRoomCommand(MeetingRoom room) {
        this.room = room;
    }

    @Override
    public void execute() {
        room.cancelBooking();
    }
}