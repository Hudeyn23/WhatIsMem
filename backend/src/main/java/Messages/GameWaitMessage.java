package Messages;

import com.nsu.backend.Action;

public class GameWaitMessage {
    private int currentPlayerNumber;
    private Action action;

    public GameWaitMessage(int currentPlayerNumber, Action action) {
        this.currentPlayerNumber = currentPlayerNumber;
        this.action = action;
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

