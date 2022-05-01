package Messages.Server;

import com.nsu.backend.Action;

public class ServerWaitMessage extends ServerMessage {
    private int currentPlayerNumber;
    private int maxPlayerNumber;
    private Action action;

    public ServerWaitMessage(int currentPlayerNumber, int maxPlayerNumber, Action action) {
        super(ServerMessageType.Wait);
        this.currentPlayerNumber = currentPlayerNumber;
        this.action = action;
        this.maxPlayerNumber = maxPlayerNumber;
    }

    public ServerWaitMessage() {
    }

    public int getCurrentPlayerNumber() {
        return currentPlayerNumber;
    }

    public void setCurrentPlayerNumber(int currentPlayerNumber) {
        this.currentPlayerNumber = currentPlayerNumber;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public int getMaxPlayerNumber() {
        return maxPlayerNumber;
    }

    public void setMaxPlayerNumber(int maxPlayerNumber) {
        this.maxPlayerNumber = maxPlayerNumber;
    }
}

