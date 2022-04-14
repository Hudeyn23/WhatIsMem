package com.nsu.backend;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RoomService {
    private ConcurrentHashMap<Integer, Room> rooms = new ConcurrentHashMap<>();
    private AtomicInteger ID = new AtomicInteger(0);

    public Room createRoom(int players) {
        Room room = new Room(ID.getAndIncrement(), players);
        rooms.put(room.getID(), room);
        return room;
    }


    public Room getRoom(int roomId){
        return rooms.get(roomId);
    }
    public ConcurrentHashMap<Integer, Room> getRooms() {
        return rooms;
    }
}
