//package service.service;
//
//
//import lombok.RequiredArgsConstructor;
//import lombok.var;
//import model.model.ChatMessage;
//import model.model.MessageStatus;
//import model.repository.ChatMessageRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import service.exception.ResourceNotFoundException;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class ChatMessageService {
//
//    private final ChatMessageRepository repository;
//    private final ChatRoomService chatRoomService;
//
//    public ChatMessage save(ChatMessage chatMessage) {
//        chatMessage.setStatus(MessageStatus.RECEIVED);
//        repository.save(chatMessage);
//        return chatMessage;
//    }
//
//    public long countNewMessages(String senderId, String recipientId) {
//        return repository.countBySenderIdAndRecipientIdAndStatus(senderId, recipientId, MessageStatus.RECEIVED);
//    }
//
//    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
//        var chatId = chatRoomService.getChatId(senderId, recipientId, false);
//
//        var messages = chatId.map(cId -> repository.findByChatId(cId)).orElse(new ArrayList<>());
//
////        if(messages.size() > 0) {
////            updateStatuses(senderId, recipientId, MessageStatus.DELIVERED);
////        }
//
//        return messages;
//    }
//
//    public ChatMessage findById(String id) {
//        return repository
//                .findById(id)
//                .map(chatMessage -> {
//                    chatMessage.setStatus(MessageStatus.DELIVERED);
//                    return repository.save(chatMessage);
//                })
//                .orElseThrow(() ->
//                        new ResourceNotFoundException("can't find message (" + id + ")"));
//    }
//
////    public void updateStatuses(String senderId, String recipientId, MessageStatus status) {
////        Query query = new Query(
////                Criteria
////                        .where("senderId").is(senderId)
////                        .and("recipientId").is(recipientId));
////        Update update = Update.update("status", status);
////        mongoOperations.updateMulti(query, update, ChatMessage.class);
////    }
//}
