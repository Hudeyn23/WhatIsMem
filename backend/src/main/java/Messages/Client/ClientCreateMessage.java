package Messages.Client;

public class ClientCreateMessage extends ClientMessage {
    private int numberOfPlayers;
    private String roomID;

    public ClientCreateMessage() {
    }

    public ClientCreateMessage(int numberOfPlayers, String roomID) {
        super(ClientMessageType.Create);
        this.numberOfPlayers = numberOfPlayers;
        this.roomID = roomID;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }
}
