package model.repository;


import model.model.ChatRoom;
import model.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRoomRepository extends CrudRepository<ChatRoom, Long> {

//    List<ChatRoom> findBySenderIdOrRecipientId(String id, String id1);

    List<ChatRoom> findBySenderOrRecipient(User user1, User user2);
    ChatRoom findFirstBySenderAndRecipientOrRecipientAndSender(User user1, User user2, User user3, User user4);

    ChatRoom findFirstBySenderAndRecipient(User user1, User user2);
    ChatRoom findFirstByRecipientAndSender(User user1, User user2);


    ChatRoom findByChatId(String chatId);


//    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
