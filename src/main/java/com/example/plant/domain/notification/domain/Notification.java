package com.example.plant.domain.notification.domain;

import com.example.plant.domain.user.domain.User;
import com.example.plant.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notification extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    private NotificationType type;

    @Column(nullable = false)
    private boolean isCheck;

    @Builder
    public Notification(User user, String content, NotificationType type, boolean isCheck){
        this.user=user;
        this.content=content;
        this.type=type;
        this.isCheck=isCheck;
    }
}
