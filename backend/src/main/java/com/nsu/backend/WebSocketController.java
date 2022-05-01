package com.nsu.backend;

import Messages.Client.ClientConnectMessage;
import Messages.Client.ClientCreateMessage;
import Messages.Server.ServerWaitMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;


@Controller
public class WebSocketController {
    @Autowired
    RoomService roomService;

    @MessageMapping("/create")
    @SendToUser("/queue/create")
    public ClientCreateMessage createRoom(@Payload ClientCreateMessage clientCreateMessage) {
        return new ClientCreateMessage(clientCreateMessage.getNumberOfPlayers(), roomService.createRoom(clientCreateMessage.getNumberOfPlayers()).getID());
    }

    @MessageMapping("/room/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public ServerWaitMessage joinRoom(@Payload ClientConnectMessage clientConnectMessage, @DestinationVariable String roomId, SimpMessageHeaderAccessor headerAccessor) {
        Room room = roomService.getRoom(roomId);
        if (room != null) {
            headerAccessor.getSessionAttributes().put("playerName", clientConnectMessage.getUsername());
            headerAccessor.getSessionAttributes().put("room", room);
            Player player = new Player(room.getNextPlayerId(), clientConnectMessage.getUsername());
            headerAccessor.getSessionAttributes().put("player", player);
            room.addPlayer(player);
            return new ServerWaitMessage(room.getPlayersCount(), room.getMaxPlayers(), Action.PLAYERJOIN);
        } else {
            return null;
        }
    }

    @MessageExceptionHandler
    @SendToUser("/queue/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
    }

}
