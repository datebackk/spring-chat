package model.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "chat_room")
public class ChatRoom {
    @Id
    private String id;

    @Column(name = "chat_id")
    private String chatId;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User recipient;
}
