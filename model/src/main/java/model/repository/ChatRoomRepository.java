package model.repository;


import model.model.ChatRoom;
import model.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRoomRepository extends CrudRepository<ChatRoom, String> {

//    List<ChatRoom> findBySenderIdOrRecipientId(String id, String id1);

    List<ChatRoom> findBySenderOrRecipient(User user1, User user2);

//    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
