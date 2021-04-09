package api.dto;

import lombok.Data;

@Data
public class ChatRoomDTO {
    private String id;
    private String chatId;
    private String senderId;
    private String recipientId;
}
