package model.repository;


import model.model.ChatRoom;
import model.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRoomRepository extends CrudRepository<ChatRoom, Long> {


    List<ChatRoom> findBySenderOrRecipientOrderByLastMessage_DateDesc(User user1, User user2);

    ChatRoom findFirstBySenderAndRecipientOrRecipientAndSender(User user1, User user2, User user3, User user4);

    ChatRoom findFirstBySenderAndRecipient(User user1, User user2);
    ChatRoom findFirstByRecipientAndSender(User user1, User user2);


    ChatRoom findByChatId(String chatId);

}
