package com.example.phone_duck.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    //chatRoom can have many channels, so each room have a reference to the channels it belongs
    @OneToMany(mappedBy = "chatRoom")
    public List<Channel> channels;
    public ChatRoom(){}
    public ChatRoom(Long id, String title, List<Channel>channels){
        this.id = id;
        this.title=title;
        this.channels=channels;
    }
}
