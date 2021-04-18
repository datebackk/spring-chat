package api.mapper;

import api.dto.MessageDTO;
import model.model.ChatMessage;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageDTO toDTO(ChatMessage chatMessage);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ChatMessage toEntity(MessageDTO messageDTO);

    List<MessageDTO> listToDTO(List<ChatMessage> chatMessages);
}