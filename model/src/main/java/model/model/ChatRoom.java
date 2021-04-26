package model.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Data
@Table(name = "chat_room")
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chat_id")
    private String chatId;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User recipient;

    @OneToOne
    @JoinColumn(name = "last_message")
    private ChatMessage lastMessage;
}
