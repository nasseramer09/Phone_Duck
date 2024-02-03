package com.example.phone_duck.Controller;

import com.example.phone_duck.Model.Channel;
import com.example.phone_duck.Services.ChannelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/channel")
public class ChannelController {

    @Autowired
    private ChannelServices channelServices;

    @GetMapping("/channels")
    public List<Channel>getAllChannels(){
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

    @GetMapping("/search/messageContent/{messageContent}")
    public Channel getChannelByMessageContent(@PathVariable String messageContent){
        return channelServices.getChannelByMessageContent(messageContent);
    }

    @PostMapping
    public String createNewChannel(@RequestBody Channel channel){
        channelServices.creat(channel);
        return "Channel created successfully";
    }


}
