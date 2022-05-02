package Messages.Server;

public class ServerCreateMessage extends ServerMessage {
    private String roomID;

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public ServerCreateMessage(String roomID) {
        super(ServerMessageType.Create);
        this.roomID = roomID;
    }

}
