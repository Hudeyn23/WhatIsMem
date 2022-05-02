package Messages.Client;

public class ClientVoteMessage extends ClientMessage {
    private int card;

    public ClientVoteMessage(int card) {
        super(ClientMessageType.Vote);
        this.card = card;
    }

    public ClientVoteMessage() {
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }
}
