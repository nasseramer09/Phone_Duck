package com.example.phone_duck.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @JoinColumn
    private Channel channel;

}
