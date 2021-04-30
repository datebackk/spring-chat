package model.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "chat_message")
public class ChatMessage {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "chat_id")
   private String chatId;

   @Column(name = "sender_id")
   private Long senderId;

   @Column(name = "recipient_id")
   private Long recipientId;

   @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
   private LocalDateTime date;

   @Column(nullable = false)
   private String message;

   @Enumerated(EnumType.ORDINAL)
   private MessageStatus status;
}
