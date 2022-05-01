package Messages.Server;

import Messages.Server.ServerMessageType;

public class ServerMessage {
    private ServerMessageType type;

    public ServerMessage(ServerMessageType t) {
        type = t;
    }

    public ServerMessage(){}

    public ServerMessageType getType() {
        return type;
    }

    public void setType(ServerMessageType type) {
        this.type = type;
    }
}
