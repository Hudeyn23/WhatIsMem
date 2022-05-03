package com.nsu.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RoomService {
    private final int max = 9999;
    private final int min = 1000;
    private ConcurrentHashMap<String, Room> rooms = new ConcurrentHashMap<>();
    private final Set<String> roomsSet = ConcurrentHashMap.newKeySet();
    private final Random random = new Random();

    public Room createRoom(int players) {
        String id;
        do {
            id = String.format("%04d", random.nextInt((max - min) + min));
        } while (!roomsSet.add(id));
        Room room = new Room(id, players);
        rooms.put(id, room);
        return room;
    }

    public Room getRoom(String roomId) {
        return rooms.get(roomId);
    }
}
