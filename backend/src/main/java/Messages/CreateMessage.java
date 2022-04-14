package Messages;

public class CreateMessage {
    private int numberOfPlayer;
    private int roomId;
    public CreateMessage() {
    }

    public CreateMessage(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    public CreateMessage(int numberOfPlayer, int roomId) {
        this.numberOfPlayer = numberOfPlayer;
        this.roomId = roomId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public void setNumberOfPlayer(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }
}
