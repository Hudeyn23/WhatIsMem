package Messages.Client;

public class ClientCreateMessage extends ClientMessage {
    private int numberOfPlayers;

    public ClientCreateMessage() {
    }

    public ClientCreateMessage(int numberOfPlayers) {
        super(ClientMessageType.Create);
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

}
