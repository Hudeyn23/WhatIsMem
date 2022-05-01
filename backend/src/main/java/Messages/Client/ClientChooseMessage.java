package Messages.Client;

public class ClientChooseMessage extends ClientMessage {
    private int card;

    public ClientChooseMessage(int card) {
        this.card = card;
    }

    public ClientChooseMessage() {
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }
}
