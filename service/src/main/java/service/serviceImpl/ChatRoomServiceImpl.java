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
        return chatRoomRepository.findBySenderOrRecipient(user, user);
    }
}
