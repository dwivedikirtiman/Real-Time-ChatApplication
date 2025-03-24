package com.chat.app.controller;

import com.chat.app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/sendMessage")     // Incoming messages
    @SendTo("/topic/messages")          // Broadcast messages
    public ChatMessage sendMessage(ChatMessage message) {
        System.out.println("Received from Client: " + message.getSender() + ": " + message.getContent());
        return message; // Broadcasts the message to all connected clients
    }
}
