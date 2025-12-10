package com.example.miro.domain.alarm.entity;

import com.example.miro.domain.alarm.enums.NotificationType;
import com.example.miro.domain.schedule.entity.Schedule;
import com.example.miro.domain.user.entity.User;
import com.example.miro.domain.userDevice.entity.UserDevice;
import com.example.miro.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "notification")
public class Notification extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 알림을 받는 사용자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // 어떤 기기와 관련된 알림인지
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userDevice_id")
    private UserDevice userDevice;

    // 스케줄 관련 알림이면 존재
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 50)
    private NotificationType type;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "message", nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(name = "progress")
    private Integer progress; // CLEANING_PROGRESS에서만 사용

    @Column(name = "isRead", nullable = false)
    private boolean isRead;

    public void markAsRead() {
        this.isRead = true;
    }
}
