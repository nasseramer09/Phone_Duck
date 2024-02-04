package com.example.phone_duck.Services;
import com.example.phone_duck.Model.Channel;
import com.example.phone_duck.Repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ChannelServices {

    private  ChannelRepository channelRepository;
    @Autowired
   public ChannelServices(ChannelRepository channelRepository){
       this.channelRepository = channelRepository;
   }

    public List<Channel>getAll(){
        return channelRepository.findAll();
    }

    public void creat(Channel channel){
        channelRepository.save(channel);
    }

    public Channel getChannelById(Long id){
        return channelRepository.findChannelById(id);
    }

    public Channel getChannelByTitle(String title){
        return channelRepository.findChannelByTitle(title);
    }

}
