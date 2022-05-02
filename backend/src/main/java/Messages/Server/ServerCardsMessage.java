package Messages.Server;

import java.util.HashSet;
import java.util.Set;

public class ServerCardsMessage extends ServerMessage {
    private Set<Integer> cards;

    public ServerCardsMessage() {
        super(ServerMessageType.Cards);
        cards = new HashSet<>();
    }

    public Set<Integer> getCards() {
        return cards;
    }

    public void setCards(Set<Integer> cards) {
        this.cards = cards;
    }
}
