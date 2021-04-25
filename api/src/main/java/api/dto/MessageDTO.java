package api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDTO {
    private Long id;
    private String chatId;
    private Long recipientId;
    private Long senderId;
    private String status;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime date;
    private String message;
}
