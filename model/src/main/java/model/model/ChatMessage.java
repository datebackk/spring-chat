package model.model;

import lombok.*;


import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "chat_message")
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

   private String message;
   private MessageStatus status;
}
