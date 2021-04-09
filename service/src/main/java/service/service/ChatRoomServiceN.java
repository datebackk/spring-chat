package service.service;

import model.model.ChatRoom;

import java.util.List;

public interface ChatRoomServiceN {
    List<ChatRoom> findBySenderIdOrRecipientId(String id);
}
