package com.example.phone_duck.Controller;

import com.example.phone_duck.Model.Message;
import com.example.phone_duck.Services.MessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageServices messageServices;

    @GetMapping("/messages")
    public List<Message>getAll(){
        return messageServices.getAll();
    }
    @GetMapping("/search/id/{id}")
    public Message getMessageById(@PathVariable Long id){
        return messageServices.getMessageById(id);
    }

    @GetMapping("/search/content/{content}")
    public Message getMessageByMessageContent(@PathVariable String content) {
        return messageServices.getMessageByMessageContent(content);
    }

    @PostMapping
    public String createMessage(@RequestBody Message message){
        messageServices.create(message);
        return "message created successfully";    }
}
