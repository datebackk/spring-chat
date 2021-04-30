package model.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "public_chat_room")
public class PublicChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chat_id")
    private String chatId;

    @OneToOne
    @JoinColumn(name = "last_message")
    private ChatMessage lastMessage;
}
