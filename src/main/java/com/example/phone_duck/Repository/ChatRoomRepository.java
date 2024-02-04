package com.example.phone_duck.Repository;

import com.example.phone_duck.Model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    ChatRoom findChatRoomById(Long id);
    ChatRoom findChatRoomByTitle(String title);
}
