package com.example.phone_duck.Controller;

import com.example.phone_duck.Model.Channel;
import com.example.phone_duck.Model.Message;
import com.example.phone_duck.Services.ChannelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/channel")
public class ChannelController {

    @Autowired
    private ChannelServices channelServices;

    @GetMapping
    public List<Channel> getAll(){
        return channelServices.getAll();
    }

    @GetMapping("/search/id/{id}")
    public Channel getChannelById(@PathVariable Long id){
        return channelServices.getChannelById(id);
    }

    @GetMapping("/search/title/{title}")
    public Channel getChannelByTitle(@PathVariable String title){
        return channelServices.getChannelByTitle(title);
    }

    @PostMapping
    public ResponseEntity<String> createNewChannel(@RequestBody Channel channel){
        try {
            channelServices.creat(channel);
            return ResponseEntity.status(HttpStatus.CREATED).body("Channel created successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problem accured creating channel");
        }
    }
    @DeleteMapping("/{id}")
    public String deleteChannel(@PathVariable Long id){
        channelServices.deleteChannel(id);
        return "Channel deleted successfully";
 }

    @PatchMapping("/{id}")
    public ResponseEntity<String>updateChannelTitle(@PathVariable Long id, @RequestBody Channel uppdateChannelTitle){
        channelServices.updateChannel(id, uppdateChannelTitle);
        return ResponseEntity.ok("Channel title updated successfully");
 }

    @PutMapping("/{id}")
    public ResponseEntity<String>createNewMessage(@PathVariable Long id, @RequestBody Message neweMessage){
        channelServices.putNewMessage(id, neweMessage);
        return ResponseEntity.ok("New message created successfully");
    }

    @GetMapping("/{id}/messages")
    public List<Message> getAllMessageSInChannel(@PathVariable Long id){
        return channelServices.getAllMessagesInChannel(id);
    }



}
