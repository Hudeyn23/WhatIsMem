package Messages;

public class CreateMessage {
    private int numberOfPlayer;
    private String roomId;
    public CreateMessage() {
    }

    public CreateMessage(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    public CreateMessage(int numberOfPlayer, String roomId) {
        this.numberOfPlayer = numberOfPlayer;
        this.roomId = roomId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public void setNumberOfPlayer(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }
}
