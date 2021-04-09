package model.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "chat_notification")
public class ChatNotification {
    @Id
    private String id;
    private String senderId;
    private String senderName;
}
