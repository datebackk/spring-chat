package api.controller;

import api.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import model.model.ChatMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.service.ChatMessageServiceN;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageController {
    private final ChatMessageServiceN chatMessageService;
    private final MessageMapper messageMapper;

    @GetMapping("/message/{chatId}")
    public ResponseEntity<?> getChatMessages(@PathVariable String chatId) {
        List<ChatMessage> chatMessages = chatMessageService.findByChatId(chatId);
        return new ResponseEntity<>(chatMessages, HttpStatus.OK);
    }
}
