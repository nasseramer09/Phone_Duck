package com.example.phone_duck.Services;
import com.example.phone_duck.Model.Channel;
import com.example.phone_duck.Model.Message;
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

    public void deleteChannel(Long id){
        channelRepository.deleteById(id);
    }

    public void updateChannel(Long id, Channel updateChannelTitle){
        Channel curentChannel=channelRepository.findChannelById(id);

        if (updateChannelTitle.getTitle()!=null){
            curentChannel.setTitle(updateChannelTitle.getTitle());
        }
        channelRepository.save(curentChannel);
    }

    public void putNewMessage(Long id, Message newMessage){
        Channel curentChannel = channelRepository.findChannelById(id);
        newMessage.setChannel(curentChannel);
        curentChannel.getMessages().add(newMessage);
        channelRepository.save(curentChannel);
    }

    public List<Message> getAllMessagesInChannel(Long id) {
        Channel channel = channelRepository.findChannelById(id);
        return channel.getMessages();
    }
}
