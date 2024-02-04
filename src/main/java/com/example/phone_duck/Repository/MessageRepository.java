package com.example.phone_duck.Repository;

import com.example.phone_duck.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository <Message, Long>{
    Message findMessageById(Long id);
    Message findMessageByMessageContent(String content);
}
