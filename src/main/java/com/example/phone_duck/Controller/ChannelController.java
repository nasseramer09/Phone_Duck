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
    public String deleteChannel(@PathVariable Long id){
        channelServices.deleteChannel(id);
        return "Channel deleted successfully";
 }

    @PatchMapping("/{id}")
    public ResponseEntity<String>updateChannelTitle(@PathVariable Long id, @RequestBody Channel updateChannelTitle){
        channelServices.updateChannel(id, updateChannelTitle);
        return ResponseEntity.ok("Channel title updated successfully");
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

    @GetMapping("/{id}")
    public ResponseEntity<Channel> getAllMessageSInChannel(@PathVariable Long id){
        Channel channel = channelServices.getAllMessagesInChannel(id);
        if (channel==null){
            ResponseEntity.notFound().build();}

        return ResponseEntity.ok(channel);
    }



}
