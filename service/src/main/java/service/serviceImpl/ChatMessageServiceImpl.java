package service.serviceImpl;

import lombok.RequiredArgsConstructor;
import model.model.ChatMessage;
import model.repository.ChatMessageRepository;
import org.springframework.stereotype.Service;
import service.service.ChatMessageServiceN;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageServiceN {

    private final ChatMessageRepository chatMessageRepository;

    @Override
    public List<ChatMessage> findByChatId(String chatId) {
        return chatMessageRepository.findByChatId(chatId);
    }
}
