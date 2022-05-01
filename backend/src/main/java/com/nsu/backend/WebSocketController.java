package com.nsu.backend;

import Messages.ConnectMessage;
import Messages.CreateMessage;
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
    public CreateMessage createRoom(@Payload CreateMessage createMessage) {
        return new CreateMessage(createMessage.getNumberOfPlayer(), roomService.createRoom(createMessage.getNumberOfPlayer()).getID());
    }

    @MessageMapping("/room/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public ServerWaitMessage joinRoom(@Payload ConnectMessage connectMessage, @DestinationVariable String roomId, SimpMessageHeaderAccessor headerAccessor) {
        Room room = roomService.getRoom(roomId);
        if (room != null) {
            headerAccessor.getSessionAttributes().put("playerName", connectMessage.getPlayerName());
            headerAccessor.getSessionAttributes().put("room", room);
            Player player = new Player(room.getNextPlayerId(), connectMessage.getPlayerName());
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
