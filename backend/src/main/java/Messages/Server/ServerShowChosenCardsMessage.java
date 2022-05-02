package Messages.Server;

import java.util.HashSet;
import java.util.Set;

public class ServerShowChosenCardsMessage extends ServerMessage {
    private Set<Integer> cards;

    public ServerShowChosenCardsMessage() {
        super(ServerMessageType.ShowChosenCards);
        cards = new HashSet<>();
    }

    public Set<Integer> getCards() {
        return cards;
    }

    public void setCards(Set<Integer> cards) {
        this.cards = cards;
    }
}
