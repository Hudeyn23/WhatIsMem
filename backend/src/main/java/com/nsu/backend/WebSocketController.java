package com.nsu.backend;


import Messages.Server.ServerMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;


@Controller
public class WebSocketController {
    @Autowired
    MessageProcess messageProcessor;

    @MessageMapping("/create")
    @SendToUser("/queue/create")
    public ServerMessage createRoom(@Payload String clientCreateMessage, SimpMessageHeaderAccessor headerAccessor) {
        ServerMessage message = messageProcessor.process(clientCreateMessage, headerAccessor);
        System.out.println(message);
        return message;
    }

    @MessageMapping("/room/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public ServerMessage joinRoom(@Payload String message, @DestinationVariable String roomId, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("roomId", roomId);
        return messageProcessor.process(message, headerAccessor);
    }

    @MessageExceptionHandler
    @SendToUser("/queue/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
    }

}
