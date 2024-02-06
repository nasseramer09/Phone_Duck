package com.example.phone_duck.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Entity
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    private String title;
    //A message only belongs to a channel
    @JsonIgnore
    @OneToMany(mappedBy = "channel")
    private List<Message> messages;

}
