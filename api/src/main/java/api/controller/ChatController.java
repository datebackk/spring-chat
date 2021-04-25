package api.controller;

import api.dto.ChatRoomDTO;
import api.mapper.ChatRoomMapper;
import lombok.RequiredArgsConstructor;
import model.model.ChatRoom;
import model.model.MessageStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import security.service.AuthService;
import service.service.ChatMessageService;
import service.service.ChatRoomService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatRoomService chatRoomService;
    private final ChatMessageService chatMessageService;

    private final ChatRoomMapper chatRoomMapper;
    private final AuthService authService;

    @GetMapping("/chats")
    public ResponseEntity<?> getChats(HttpServletRequest req) {
        List<ChatRoomDTO> chatRoomDTOS = chatRoomMapper.listToDTO(chatRoomService.findBySenderOrRecipient(authService.whoami(req)));
        chatRoomDTOS.stream().forEach(p -> p.setNewMessages(chatMessageService.countChatMessageByChatIdAndStatus(p.getChatId(), MessageStatus.SENT)));
        return new ResponseEntity<>(chatRoomDTOS, HttpStatus.OK);
    }
}
