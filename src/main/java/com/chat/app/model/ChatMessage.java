package com.chat.app.model;

public class ChatMessage {
    private String sender;
    private String content;

    // No-argument constructor for data binding
    public ChatMessage() {}

    // Constructor
    public ChatMessage(String sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    // Getters and Setters
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
