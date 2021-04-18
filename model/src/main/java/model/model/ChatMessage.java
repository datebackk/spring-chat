package model.model;

import lombok.*;

import javax.persistence.*;


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

   private String message;

   @Enumerated(EnumType.ORDINAL)
   private MessageStatus status;
}
