package Messages.Client;

public class ClientCreateMessage extends ClientMessage {
    private int numberOfPlayer;
    public ClientCreateMessage() {
    }

    public ClientCreateMessage(int numberOfPlayers, String roomID) {
        super(ClientMessageType.Create);
        this.numberOfPlayer = numberOfPlayers;
    }

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public void setNumberOfPlayer(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

}
