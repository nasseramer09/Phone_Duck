package com.example.phone_duck.Services;

import com.example.phone_duck.Model.Message;
import com.example.phone_duck.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServices {
    private MessageRepository messageRepository;
    @Autowired
    public MessageServices(MessageRepository messageRepository){
        this.messageRepository=messageRepository;
    }

    public List<Message>getAll(){
        return messageRepository.findAll();
    }

    public void create(Message message){
        messageRepository.save(message);
    }

    public Message getMessageById(Long id){
        return messageRepository.findMessageById(id);
    }

    public Message getMessageByMessageContent(String content){
        return messageRepository.findMessageByMessageContent(content);
    }

    public void deleteMessage(Long id){
        messageRepository.deleteById(id);
    }
}

