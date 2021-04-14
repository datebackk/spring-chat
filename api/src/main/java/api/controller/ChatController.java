package api.controller;

import api.mapper.ChatRoomMapper;
import lombok.RequiredArgsConstructor;
import model.model.ChatRoom;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import security.service.AuthService;
import service.service.ChatRoomServiceN;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatRoomServiceN chatRoomServiceN;

    private final ChatRoomMapper chatRoomMapper;
    private final AuthService authService;

    @GetMapping("/chats")
    public ResponseEntity<?> getChats(HttpServletRequest req) {
        List<ChatRoom> chatRooms = chatRoomServiceN.findBySenderOrRecipient(authService.whoami(req));
        return new ResponseEntity<>(chatRoomMapper.listToDTO(chatRooms), HttpStatus.OK);
    }
}
