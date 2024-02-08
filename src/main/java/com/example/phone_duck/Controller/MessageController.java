/*package com.example.phone_duck.Controller;

import com.example.phone_duck.Model.Message;
import com.example.phone_duck.Services.MessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageServices messageServices;

    @GetMapping
    public ResponseEntity<List<Message>>getAll(){
        List<Message> messages=messageServices.getAll();
        if (messages.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(messages);
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
        return "message created successfully";
    }
    @DeleteMapping("/{id}")
    public String deleteMessage(Long id){
        messageServices.deleteMessage(id);
        return "Message has been deleted successfully";
    }
}*/
