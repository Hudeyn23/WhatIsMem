package Messages.Server;

import com.nsu.backend.VoteResult;

import java.util.Set;

public class ServerShowVoteResultsMessage extends ServerMessage {
    private Set<VoteResult> votes;
    private int winner;

    public ServerShowVoteResultsMessage(Set<VoteResult> votes, int winner) {
        super(ServerMessageType.ShowVoteResults);
        this.votes = votes;
        this.winner = winner;
    }

    public Set<VoteResult> getVotes() {
        return votes;
    }

    public void setVotes(Set<VoteResult> votes) {
        this.votes = votes;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public ServerShowVoteResultsMessage() {
    }
}
