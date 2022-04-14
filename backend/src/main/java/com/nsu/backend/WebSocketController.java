package com.nsu.backend;

import Messages.ConnectMessage;
import Messages.CreateMessage;
import Messages.GameWaitMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


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
    public GameWaitMessage joinRoom(@Payload ConnectMessage connectMessage, @DestinationVariable int roomId) {
        Room room = roomService.getRoom(roomId);
        Player player = new Player(room.getNextPlayerId(), connectMessage.getPlayerName());
        room.addPlayer(player);
        return new GameWaitMessage(room.getPlayersCount(), Action.PLAYERJOIN);
    }

    @MessageExceptionHandler
    @SendToUser("/queue/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
    }

}
