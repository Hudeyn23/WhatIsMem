package Messages.Client;

public class ClientConnectMessage extends ClientMessage {
    private String playerName;

    public ClientConnectMessage(String playerName) {
        super(ClientMessageType.Connect);
        this.playerName = playerName;
    }

    public ClientConnectMessage() {
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
