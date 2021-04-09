package api.controller;

import api.mapper.ChatRoomMapper;
import lombok.RequiredArgsConstructor;
import model.model.ChatRoom;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.service.ChatRoomServiceN;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatRoomServiceN chatRoomServiceN;

    private final ChatRoomMapper chatRoomMapper;

    @GetMapping("/chats/{userId}")
    public ResponseEntity<?> getChats(@PathVariable String userId) {
        List<ChatRoom> chatRooms = chatRoomServiceN.findBySenderIdOrRecipientId(userId);
        return new ResponseEntity<>(chatRoomMapper.listToDTO(chatRooms), HttpStatus.OK);
    }
}
