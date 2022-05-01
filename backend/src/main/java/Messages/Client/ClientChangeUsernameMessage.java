package Messages.Client;

public class ClientChangeUsernameMessage extends ClientMessage {
    private String newUsername;

    public ClientChangeUsernameMessage(String newUsername) {
        super(ClientMessageType.ChangeUserName);
        this.newUsername = newUsername;
    }

    public ClientChangeUsernameMessage() {
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }
}
