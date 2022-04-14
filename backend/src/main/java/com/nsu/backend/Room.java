package com.nsu.backend;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Room {
    private int id;
    private int maxPlayers;
    private ConcurrentLinkedQueue<Player> players = new ConcurrentLinkedQueue<>();
    private AtomicInteger playerId = new AtomicInteger(0);

    public Room(int id, int maxplayersCount) {
        this.id = id;
        this.maxPlayers = maxplayersCount;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxplayersCount) {
        this.maxPlayers = maxplayersCount;
    }

    public int getPlayersCount() {
        return players.size();
    }

    public int getNextPlayerId() {
        return playerId.getAndIncrement();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}