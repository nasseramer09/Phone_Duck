package com.example.phone_duck.Services;

import com.example.phone_duck.Model.ChatRoom;
import com.example.phone_duck.Repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatRoomServices {

    private ChatRoomRepository chatRoomRepository;
    @Autowired
    public ChatRoomServices(ChatRoomRepository chatRoomRepository){
        this.chatRoomRepository=chatRoomRepository;
    }
    public List<ChatRoom>getAll(){
        return chatRoomRepository.findAll();
    }
    public void create(ChatRoom chatRoom){
        chatRoomRepository.save(chatRoom);
    }
    public ChatRoom getChatRoomById(Long id){
        return chatRoomRepository.findChatRoomById(id);
    }
    public ChatRoom getChatRoomByTitle(String title){
        return chatRoomRepository.findChatRoomByTitle(title);
    }
    public void deleteChatRoom(Long id){
        chatRoomRepository.deleteById(id);
    }


}
