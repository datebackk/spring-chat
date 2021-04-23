package service.service;

import model.model.ChatMessage;
import model.model.MessageStatus;

import java.util.List;

public interface ChatMessageServiceN {
    List<ChatMessage> findByChatId(String chatId);

    Long countChatMessageByChatIdAndStatus(String chatId, MessageStatus messageStatus);

    void save(ChatMessage message);
}
