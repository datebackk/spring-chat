package api.mapper;

import api.dto.ChatRoomDTO;
import model.model.ChatRoom;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatRoomMapper {
    ChatRoomDTO toDTO(ChatRoom chatRoom);
    ChatRoom toEntity(ChatRoomDTO chatRoomDTO);
    List<ChatRoomDTO> listToDTO(List<ChatRoom> chatRooms);
}
