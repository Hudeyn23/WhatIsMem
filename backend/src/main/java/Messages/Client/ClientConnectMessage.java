package Messages.Client;

public class ClientConnectMessage extends ClientMessage {
    private String username;

    public ClientConnectMessage(String username) {
        super(ClientMessageType.Connect);
        this.username = username;
    }

    public ClientConnectMessage() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
