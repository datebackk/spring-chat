package service.serviceImpl;

import lombok.RequiredArgsConstructor;
import model.model.ChatMessage;
import model.model.MessageStatus;
import model.repository.ChatMessageRepository;
import org.springframework.stereotype.Service;
import service.service.ChatMessageService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    @Override
    public List<ChatMessage> findByChatId(String chatId) {
        return chatMessageRepository.findByChatId(chatId);
    }

    @Override
    public Long countChatMessageByChatIdAndStatusAndRecipientId(String chatId, MessageStatus messageStatus, Long id) {
        return chatMessageRepository.countChatMessageByChatIdAndStatusAndRecipientId(chatId, messageStatus, id);
    }

    @Override
    public Optional<ChatMessage> findById(Long id) {
        return chatMessageRepository.findById(id);
    }

    @Override
    public ChatMessage saveAndFlushChatMessage(ChatMessage chatMessage) {
        return chatMessageRepository.saveAndFlush(chatMessage);
    }

    @Override
    public void save(ChatMessage message) {
        chatMessageRepository.save(message);
    }
}
