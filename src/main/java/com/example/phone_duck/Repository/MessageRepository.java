package com.example.phone_duck.Repository;

import com.example.phone_duck.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository <Message, Long>{
    Message findMessageById(Long id);
}
