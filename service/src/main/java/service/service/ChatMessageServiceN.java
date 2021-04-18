package service.service;

import model.model.ChatMessage;

import java.util.List;

public interface ChatMessageServiceN {
    List<ChatMessage> findByChatId(String chatId);

    void save(ChatMessage message);
}
