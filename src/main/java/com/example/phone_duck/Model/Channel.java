package com.example.phone_duck.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Channel {
    @Id
    private Long id;
    private String title;
    public Long getId() {
        return id;
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


}
