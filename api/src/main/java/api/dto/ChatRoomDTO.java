package api.dto;

import lombok.Data;

@Data
public class ChatRoomDTO {
    private Long id;
    private String chatId;
    private UserDTO sender;
    private UserDTO recipient;
    private Long newMessages;
    private MessageDTO lastMessage;
}
