
public class BookRoomCommand implements Command {
    private MeetingRoom room;
    private String startTime;
    private int duration;

    public BookRoomCommand(MeetingRoom room, String startTime, int duration) {
        this.room = room;
        this.startTime = startTime;
        this.duration = duration;
    }

    @Override
    public void execute() {
        room.bookRoom(startTime, duration);
    }
}


