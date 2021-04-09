package model.repository;


import model.model.ChatRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRoomRepository extends CrudRepository<ChatRoom, String> {

    List<ChatRoom> findBySenderIdOrRecipientId(String id, String id1);

    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
