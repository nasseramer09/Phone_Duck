package com.example.phone_duck.Services;
import com.example.phone_duck.Model.Channel;
import com.example.phone_duck.Model.Message;
import com.example.phone_duck.Repository.ChannelRepository;
import com.example.phone_duck.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ChannelServices {

    private  ChannelRepository channelRepository;
    private MessageRepository messageRepository;
    @Autowired
   public ChannelServices(ChannelRepository channelRepository, MessageRepository messageRepository){
       this.channelRepository = channelRepository;
       this.messageRepository=messageRepository;
   }

    public List<Channel>getAll(){
        List<Channel>channels=channelRepository.findAll();
        for (Channel channel:channels){
            channel.setMessages(null);
        }
        return channels;
    }

    public void creat(Channel channel){
        channelRepository.save(channel);
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
        messageRepository.save(newMessage);
    }

    public Channel getAllMessagesInChannel(Long id) {
        Channel channel = channelRepository.findChannelById(id);
        return channel;
    }

    public void updateMessageContent(Long id, Message messageToUpdate){
        Message curentMessage=messageRepository.findMessageById(id);

        if (messageToUpdate.getMessageContent()!=null){
            curentMessage.setMessageContent(messageToUpdate.getMessageContent());
        }
        messageRepository.save(curentMessage);
    }

    public void deleteMessage(Long id){
        Message message = messageRepository.findMessageById(id);
        if (message!=null){
            Channel channel = message.getChannel();
            channel.getMessages().remove(message);
            channelRepository.save(channel);
            messageRepository.deleteById(id);
        }
    }
}