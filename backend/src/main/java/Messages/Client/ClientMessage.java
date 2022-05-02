package Messages.Client;

public class ClientMessage {
    private ClientMessageType type;

    public ClientMessage(ClientMessageType type) {
        this.type = type;
    }

    public ClientMessage() {
    }

    public ClientMessageType getType() {
        return type;
    }

    public void setType(ClientMessageType type) {
        this.type = type;
    }

}
