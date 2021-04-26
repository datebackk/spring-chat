package service.service;

import model.model.ChatMessage;
import model.model.MessageStatus;

import java.util.List;
import java.util.Optional;

public interface ChatMessageService {
    List<ChatMessage> findByChatId(String chatId);

    Long countChatMessageByChatIdAndStatusAndRecipientId(String chatId, MessageStatus messageStatus, Long id);

    Optional<ChatMessage> findById(Long id);

    ChatMessage saveAndFlushChatMessage(ChatMessage chatMessage);

    void save(ChatMessage message);
}
