package Messages.Server;

public class ServerSituationMessage extends ServerMessage {
    private int situationID;

    public ServerSituationMessage(int situationID) {
        super(ServerMessageType.Situation);
        this.situationID = situationID;
    }

    public ServerSituationMessage() {}

    public int getSituationID() {
        return situationID;
    }

    public void setSituationID(int situationID) {
        this.situationID = situationID;
    }
}
