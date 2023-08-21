package com.example.chatsystem.Repository;

import com.example.chatsystem.Model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat , Integer> {
    Chat findChatById(Integer id);
}
