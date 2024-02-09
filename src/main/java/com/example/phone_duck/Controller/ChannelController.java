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

    @GetMapping("/channels")
    public ResponseEntity< List<Channel>> getAll(){
        List<Channel> channels=channelServices.getAll();
        if (channels.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(channels);
    }

    //To get a channel and messages in it based on id
    @GetMapping("/{id}")
    public ResponseEntity<Channel> getAllMessageSInChannel(@PathVariable Long id){
        Channel channel = channelServices.getAllMessagesInChannel(id);
        if (channel==null){
            ResponseEntity.notFound().build();}

        return ResponseEntity.ok(channel);
    }
    @PostMapping()
    public ResponseEntity<String> createNewChannel(@RequestBody Channel channel){
        try {
            channelServices.creat(channel);
            return ResponseEntity.status(HttpStatus.CREATED).body("Channel created successfully");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problem occurred during creating channel");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity< String> deleteChannel(@PathVariable Long id){
        try {
            channelServices.deleteChannel(id);
            return ResponseEntity.ok("Channel deleted successfully");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something occurred while deleting channel ");
        }
     }
     @DeleteMapping("messages/{id}")
     public ResponseEntity<String>deleteMessage(@PathVariable Long id){
        try {
            channelServices.deleteMessage(id);
            return ResponseEntity.ok("Message deleted successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong while deleting message ");
        }
     }

    @PatchMapping("/{id}")
    public ResponseEntity<String>updateChannelTitle(@PathVariable Long id, @RequestBody Channel updateChannelTitle){
        channelServices.updateChannel(id, updateChannelTitle);
        return ResponseEntity.ok("Channel title updated successfully");
    }

    @PatchMapping("/messages/{id}")
    public ResponseEntity<String>updateMessageContent(@PathVariable Long id, @RequestBody Message newMessageContent){
        try {
            channelServices.updateMessageContent(id, newMessageContent);
            return ResponseEntity.ok("Message updated successfully");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong while updating message content");
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String>createNewMessage(@PathVariable Long id, @RequestBody Message neweMessage){
       try {
           channelServices.putNewMessage(id, neweMessage);
           return ResponseEntity.status(HttpStatus.CREATED).body(" Message created successfully ");
       } catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong while creating message in channel");
       }
    }

}
