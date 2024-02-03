package com.example.phone_duck.Services;
import com.example.phone_duck.Model.Channel;
import com.example.phone_duck.Repository.ChannelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ChannelServices {
    private  ChannelRepo channelRepo;
    @Autowired
    public ChannelServices(ChannelRepo channelRepo){
       this.channelRepo=channelRepo;
   }

    public List<Channel>getAll(){
        return channelRepo.findAll();
    }

    public void creat(Channel channel){
        channelRepo.save(channel);
    }

    public Channel getChannelById(Long id){
        return channelRepo.findChannelById(id);
    }

    public Channel getChannelByTitle(String title){
        return channelRepo.findChannelByTitle(title);
    }

    public Channel getChannelByMessageContent(String messageContent){
        return channelRepo.findChannelByMessageContent(messageContent);
    }
}
