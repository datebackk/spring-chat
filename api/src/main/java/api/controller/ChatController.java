package api.controller;

import api.dto.ChatRoomDTO;
import api.mapper.ChatRoomMapper;
import lombok.RequiredArgsConstructor;
import model.model.ChatRoom;
import model.model.MessageStatus;
import model.model.User;
import model.repository.ChatRoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import security.service.AuthService;
import service.service.ChatMessageService;
import service.service.ChatRoomService;
import service.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatRoomService chatRoomService;
    private final ChatMessageService chatMessageService;
    private final UserService userService;
    private final ChatRoomRepository chatRoomRepository;

    private final ChatRoomMapper chatRoomMapper;
    private final AuthService authService;

    @GetMapping("/chats")
    public ResponseEntity<?> getChats(@RequestParam(defaultValue = "all") String amount,
                                      @RequestParam(defaultValue = "email") String userEmail,
                                      HttpServletRequest req) {
        if (amount.equals("all")) {
            List<ChatRoomDTO> chatRoomDTOS = chatRoomMapper.listToDTO(chatRoomService.findBySenderOrRecipient(authService.whoami(req)));
            chatRoomDTOS.stream().forEach(p -> p.setNewMessages(chatMessageService.countChatMessageByChatIdAndStatusAndRecipientId(p.getChatId(), MessageStatus.SENT, authService.whoami(req).getId())));
            return new ResponseEntity<>(chatRoomDTOS, HttpStatus.OK);
        } else {
            User user = userService.findByEmail(userEmail);
            ChatRoomDTO chatRoomDTO = chatRoomMapper.toDTO(chatRoomRepository.findFirstBySenderAndRecipient(authService.whoami(req), user));

            if (chatRoomDTO == null) {
                chatRoomDTO = chatRoomMapper.toDTO(chatRoomRepository.findFirstByRecipientAndSender(authService.whoami(req), user));
            }

            chatRoomDTO.setNewMessages(chatMessageService.countChatMessageByChatIdAndStatusAndRecipientId(chatRoomDTO.getChatId(), MessageStatus.SENT, authService.whoami(req).getId()));
            return new ResponseEntity<>(chatRoomDTO, HttpStatus.OK);
        }
    }

    @PostMapping("/chats")
    public ResponseEntity<?> createNewChat(@RequestBody ChatRoomDTO chatRoomDTO) {
        User sender = userService.findByEmail(chatRoomDTO.getSender().getEmail());
        User recipient = userService.findByEmail(chatRoomDTO.getRecipient().getEmail());
        ChatRoom chatRoom = chatRoomMapper.toEntity(chatRoomDTO);
        chatRoom.setSender(sender);
        chatRoom.setRecipient(recipient);
        chatRoomService.save(chatRoom);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
