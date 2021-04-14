package api.mapper;

import api.dto.ChatRoomDTO;
import api.dto.MessageDTO;
import model.model.ChatMessage;
import model.model.ChatRoom;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageDTO toDTO(ChatMessage chatMessage);
    ChatMessage toEntity(MessageDTO messageDTO);
    List<MessageDTO> listToDTO(List<ChatMessage> chatMessages);
}
