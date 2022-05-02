package Messages.Server;

import com.nsu.backend.Action;

public class ServerWaitMessage extends ServerMessage {
    private int current;
    private int max;
    private Action action;

    public ServerWaitMessage(int current, int max, Action action) {
        super(ServerMessageType.Wait);
        this.current = current;
        this.action = action;
        this.max = max;
    }

    public ServerWaitMessage() {
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}

