package service.service;

import model.model.ChatRoom;
import model.model.User;

import java.util.List;

public interface ChatRoomService {
    List<ChatRoom> findBySenderOrRecipient(User user);
}
