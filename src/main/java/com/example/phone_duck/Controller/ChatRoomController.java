package com.example.phone_duck.Controller;

import com.example.phone_duck.Model.Channel;
import com.example.phone_duck.Model.ChatRoom;
import com.example.phone_duck.Services.ChatRoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chatRoom")
public class ChatRoomController {

    @Autowired
    private ChatRoomServices chatRoomServices;

    @GetMapping
    public List<ChatRoom>getAll(){
        return chatRoomServices.getAll();
    }

    @GetMapping("/search/id/{id}")
    public ChatRoom getChatRoomById(@PathVariable Long id){
        return chatRoomServices.getChatRoomById(id);
    }

    @GetMapping("/search/title/{title}")
    public ChatRoom getChatRoomByTitle(@PathVariable String title){
        return chatRoomServices.getChatRoomByTitle(title);
    }

    @PostMapping
    public String createChatRoom(@RequestBody ChatRoom chatRoom){
        chatRoomServices.create(chatRoom);
        return "ChatRoom created successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteChatRoom(@PathVariable Long id){
        chatRoomServices.deleteChatRoom(id);
        return "ChatRoom has been deletes successfully";
    }


}
