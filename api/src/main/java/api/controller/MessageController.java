package api.controller;

import api.dto.CountedMessages;
import api.dto.MessageDTO;
import api.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import model.model.ChatMessage;
import model.model.MessageStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import service.service.ChatMessageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final ChatMessageService chatMessageService;
    private final MessageMapper messageMapper;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{to}")
    public void sendWsMessage(@DestinationVariable String to, MessageDTO messageDTO) {
        simpMessagingTemplate.convertAndSend("/topic/messages/" + to, messageDTO);
    }

    @MessageMapping("/message-status/{to}")
    public void updateWsMessageStatus(@DestinationVariable String to, MessageDTO messageDTO) {
        simpMessagingTemplate.convertAndSend("/topic/messages-status/" + to, messageDTO);
    }

    @GetMapping("/message/{chatId}")
    public ResponseEntity<?> getChatMessages(@PathVariable String chatId) {
        List<ChatMessage> chatMessages = chatMessageService.findByChatId(chatId);
        return new ResponseEntity<>(chatMessages, HttpStatus.OK);
    }

    @GetMapping("/new-messages/{chatId}")
    public ResponseEntity<?> getNewMessages(@PathVariable String chatId) {
        Long newMessages = chatMessageService.countChatMessageByChatIdAndStatus(chatId, MessageStatus.SENT);
        CountedMessages countedMessages = new CountedMessages();
        countedMessages.setCountedMessages(newMessages);
        return new ResponseEntity<>(countedMessages, HttpStatus.OK);
    }

    @PostMapping("/message")
    public ResponseEntity<?> sendMessage(@RequestBody MessageDTO message) {
        ChatMessage chatMessage = chatMessageService.saveAndFlushChatMessage(messageMapper.toEntity(message));
        return new ResponseEntity<>(chatMessage, HttpStatus.CREATED);
    }

    @PutMapping("/message")
    public ResponseEntity<?> updateMessage(@RequestBody MessageDTO messageDTO) {
        ChatMessage chatMessage = chatMessageService.findById(messageDTO.getId()).get();
        messageMapper.merge(chatMessage, messageDTO);
        MessageDTO messageDTO1 = messageMapper.toDTO(chatMessageService.saveAndFlushChatMessage(chatMessage));
        return new ResponseEntity<>(messageDTO1, HttpStatus.OK);
    }
}
