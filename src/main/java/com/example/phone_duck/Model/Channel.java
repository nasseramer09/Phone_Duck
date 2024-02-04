package com.example.phone_duck.Model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Entity
public class Channel {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    private String title;

    //A channel can belong only to one chatRoom
    @ManyToOne
    private ChatRoom chatRoom;
    //A message only belongs to a channel
    @OneToMany(mappedBy = "channel")
    private List<Message> messages;

}
