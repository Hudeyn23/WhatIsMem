package com.nsu.backend;

import Messages.Client.ClientConnectMessage;
import Messages.Client.ClientCreateMessage;
import Messages.Client.ClientMessage;
import Messages.Server.ServerCreateMessage;
import Messages.Server.ServerGameStartMessage;
import Messages.Server.ServerMessage;
import Messages.Server.ServerWaitMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Service;

@Service
public class MessageProcess {
    @Autowired
    ObjectMapper mapper;
    @Autowired
    RoomService roomService;

    public ServerMessage process(String message, SimpMessageHeaderAccessor headerAccessor) {
        try {
            ClientMessage clientMessage = mapper.readValue(message, ClientMessage.class);
            switch (clientMessage.getType()) {
                case Create:
                    return processCreate(message);
                case Connect:
                    return processConnect(message, headerAccessor);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private ServerMessage processCreate(String message) throws JsonProcessingException {
        ClientCreateMessage clientCreateMessage = mapper.readValue(message, ClientCreateMessage.class);
        return new ServerCreateMessage(roomService.createRoom(clientCreateMessage.getNumberOfPlayer()).getID());
    }

    private ServerMessage processConnect(String message, SimpMessageHeaderAccessor headerAccessor) throws JsonProcessingException {
        ClientConnectMessage clientConnectMessage = mapper.readValue(message, ClientConnectMessage.class);
        String roomId = (String) headerAccessor.getSessionAttributes().get("roomId");
        Room room = roomService.getRoom(roomId);
        if (room != null) {
            headerAccessor.getSessionAttributes().put("playerName", clientConnectMessage.getPlayerName());
            headerAccessor.getSessionAttributes().put("room", room);
            Player player = new Player(room.getNextPlayerId(), clientConnectMessage.getPlayerName());
            headerAccessor.getSessionAttributes().put("player", player);
            room.addPlayer(player);
            if (room.getPlayersCount() == room.getMaxPlayers()) {
                return new ServerGameStartMessage(room.getPlayers());
            }
            return new ServerWaitMessage(room.getPlayersCount(), room.getMaxPlayers(), Action.PLAYERJOIN);
        } else {
            return null;
        }
    }


}
