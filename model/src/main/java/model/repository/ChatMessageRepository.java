package model.repository;

import model.model.ChatMessage;
import model.model.MessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    List<ChatMessage> findByChatId(String chatId);

    Optional<ChatMessage> findById(Long id);

    Long countChatMessageByChatIdAndStatus(String chatId, MessageStatus messageStatus);
}