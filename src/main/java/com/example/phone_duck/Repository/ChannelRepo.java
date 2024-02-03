package com.example.phone_duck.Repository;

import com.example.phone_duck.Model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepo extends JpaRepository<Channel, Long> {
    Channel findChannelById(Long id);
    Channel findChannelByTitle(String title);
    Channel findChannelByMessageContent(String messageContent);
}
