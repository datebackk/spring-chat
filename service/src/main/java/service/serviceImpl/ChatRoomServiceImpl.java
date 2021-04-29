package service.serviceImpl;

import lombok.RequiredArgsConstructor;
import model.model.ChatRoom;
import model.model.User;
import model.repository.ChatRoomRepository;
import org.springframework.stereotype.Service;
import service.service.ChatRoomService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    @Override
    public List<ChatRoom> findBySenderOrRecipient(User user) {
        return chatRoomRepository.findBySenderOrRecipientOrderByLastMessage_DateDesc(user, user);
    }

    @Override
    public ChatRoom findByChatId(String chatId) {
        return chatRoomRepository.findByChatId(chatId);
    }

    @Override
    public ChatRoom findFirstBySenderAndRecipientOrRecipientAndSender(User user1, User user2) {
        return chatRoomRepository.findFirstBySenderAndRecipientOrRecipientAndSender(user1, user2, user2, user1);
    }

    public void save(ChatRoom chatRoom) {
        chatRoomRepository.save(chatRoom);
    }
}
