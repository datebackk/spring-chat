package service.service;


import lombok.RequiredArgsConstructor;
import lombok.var;
import model.model.ChatRoom;
import model.repository.ChatRoomRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public Optional<String> getChatId(
            String senderId, String recipientId, boolean createIfNotExist) {

        return Optional.of("12");
    }
}
