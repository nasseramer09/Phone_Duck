package com.example.phone_duck.Model;

import lombok.extern.java.Log;

public class Channel {
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
