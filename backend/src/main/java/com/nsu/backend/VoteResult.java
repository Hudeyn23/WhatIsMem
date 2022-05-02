package com.nsu.backend;

public class VoteResult {
    private int userID;
    private int votes;

    public VoteResult(int userID, int votes) {
        this.userID = userID;
        this.votes = votes;
    }

    public VoteResult() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
