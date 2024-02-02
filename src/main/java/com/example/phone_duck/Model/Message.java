package com.example.phone_duck.Model;

import java.sql.Timestamp;

public class Message {
    private Long id;
    private String messageContent;
    private Timestamp timestamp;
    private Channel channel;

    public Message(){}
    public Message(Long id, String messageContent, Timestamp timestamp, Channel channel){
        this.id=id;
        this.messageContent=messageContent;
        this.timestamp=timestamp;
        this.channel=channel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
