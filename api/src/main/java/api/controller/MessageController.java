package api.controller;

import api.dto.MessageDTO;
import api.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import model.model.ChatMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import service.service.ChatMessageServiceN;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageController {
    private final ChatMessageServiceN chatMessageService;
    private final MessageMapper messageMapper;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{to}")
    public void sendWsMessage(@DestinationVariable String to, MessageDTO messageDTO) {
        simpMessagingTemplate.convertAndSend("/topic/messages/" + to, messageDTO);
    }

    @GetMapping("/message/{chatId}")
    public ResponseEntity<?> getChatMessages(@PathVariable String chatId) {
        List<ChatMessage> chatMessages = chatMessageService.findByChatId(chatId);
        return new ResponseEntity<>(chatMessages, HttpStatus.OK);
    }

    @PostMapping("/message")
    public ResponseEntity<?> sendMessage(@RequestBody MessageDTO message) {
        chatMessageService.save(messageMapper.toEntity(message));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
