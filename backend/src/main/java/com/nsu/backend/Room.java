package com.nsu.backend;

public class Room {
    private static Integer lastID = 1;
    private Integer ID;
    private Integer players;

    public Room(Integer players) {
        this.players=players;
        ID = lastID++;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getPlayers() {
        return players;
    }

    public void setPlayers(Integer players) {
        this.players = players;
    }
}