package com.example.phone_duck.Model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
public class Channel {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    private String title;

    @ManyToOne
    private ChatRoom chatRoom;

}
