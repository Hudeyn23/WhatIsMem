package Messages;

import com.nsu.backend.Action;

public class GameWaitMessage {
    private int currentPlayerNumber;
    private int maxPlayerNumber;
    private Action action;

    public GameWaitMessage(int currentPlayerNumber, Action action, int maxPlayerNumber) {
        this.currentPlayerNumber = currentPlayerNumber;
        this.action = action;
        this.maxPlayerNumber = maxPlayerNumber;
    }

    public int getMaxPlayerNumber() {
        return maxPlayerNumber;
    }

    public void setMaxPlayerNumber(int maxPlayerNumber) {
        this.maxPlayerNumber = maxPlayerNumber;
    }

    public GameWaitMessage() {
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
}

