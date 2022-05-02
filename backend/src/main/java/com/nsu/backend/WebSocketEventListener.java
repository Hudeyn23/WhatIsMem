package com.nsu.backend;

import Messages.GameWaitMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventListener {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        Room room = (Room) headerAccessor.getSessionAttributes().get("room");
        String username = (String) headerAccessor.getSessionAttributes().get("playerName");
        if (room != null) {
            String roomId = room.getID();
            logger.info("User Disconnected: " + username);
            Player player = (Player) headerAccessor.getSessionAttributes().get("player");
            room.removePlayer(player);
            GameWaitMessage message = new GameWaitMessage();
            message.setAction(Action.PLAYERDISCONNECTED);
            message.setCurrentPlayerNumber(room.getPlayersCount());
            messagingTemplate.convertAndSend(String.format("/topic/room/%s", roomId), message);
        }
    }
}