package Messages.Server;

public class ServerRoomCreatedMessage extends ServerMessage {
    private String roomID;
    private int numberOfPlayers;

    public ServerRoomCreatedMessage(int numberOfPlayers, String roomID) {
        super(ServerMessageType.RoomCreated);
        this.roomID = roomID;
        this.numberOfPlayers = numberOfPlayers;
    }

    public ServerRoomCreatedMessage() {
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
