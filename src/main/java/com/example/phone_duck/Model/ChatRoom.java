package com.example.phone_duck.Model;

import java.util.List;

public class ChatRoom {
    private Long id;
    private String title;
    public List<Channel> channels;
    public Long getId() {
        return id;
    }
    public ChatRoom(){}

    public ChatRoom(Long id, String title, List<Channel>channels){
        this.id=id;
        this.title=title;
        this.channels=channels;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }


}
