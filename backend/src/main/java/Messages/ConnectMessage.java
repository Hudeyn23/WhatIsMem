package Messages;

public class ConnectMessage {
    private int roomId;
    private String playerName;

    public ConnectMessage(int roomId, String playerName) {
        this.roomId = roomId;
        this.playerName = playerName;
    }

    public ConnectMessage() {
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
