package com.example.phone_duck.Model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String messageContent;
    @ManyToOne
    private Channel channel;

    public Message(){}
    public Message(Long id, String messageContent, Channel channel){
        this.id=id;
        this.messageContent=messageContent;
        this.channel=channel;
    }
}
