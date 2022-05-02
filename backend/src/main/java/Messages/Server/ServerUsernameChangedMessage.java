package Messages.Server;

public class ServerUsernameChangedMessage extends ServerMessage {
    private int userID;
    private String newUsername;

    public ServerUsernameChangedMessage(int userID, String newUsername) {
        super(ServerMessageType.UsernameChanged);
        this.userID = userID;
        this.newUsername = newUsername;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public ServerUsernameChangedMessage() {
    }
}
