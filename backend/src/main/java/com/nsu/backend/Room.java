package com.nsu.backend;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Room {
    private String id;
    private int maxPlayers;
    private Set<Player> players = ConcurrentHashMap.newKeySet();
    private AtomicInteger playerId = new AtomicInteger(0);

    public Room(String id, int maxplayersCount) {
        this.id = id;
        this.maxPlayers = maxplayersCount;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
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

    public void removePlayer(Player player) {
        players.remove(player);
    }
}