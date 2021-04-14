package api.dto;

import lombok.Data;

@Data
public class MessageDTO {
    private Long id;
    private String chatId;
    private Long recipientId;
    private Long senderId;
    private String message;
}
