package Messages.Server;

import com.nsu.backend.Player;

import java.util.Set;

public class ServerGameStartMessage extends ServerMessage {
    private Set<Player> players;

    public ServerGameStartMessage(Set<Player> players) {
        super(ServerMessageType.GameStart);
        this.players = players;
    }

    public ServerGameStartMessage() {
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
