package com.example.miro.domain.alarm.entity;

import com.example.miro.domain.user.entity.User;
import com.example.miro.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "user_notification_setting")
public class UserNotificationSetting extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // 청소 관련(스케줄 시작, 청소 시작/완료 등)
    @Column(nullable = false)
    private boolean allowCleaningNotification;

    // 진행률 알림
    @Column(nullable = false)
    private boolean allowProgressNotification;

    // 기기 상태(배터리 부족, 연결 끊김 등)
    @Column(nullable = false)
    private boolean allowDeviceNotification;

    // 오류 알림
    @Column(nullable = false)
    private boolean allowErrorNotification;

    // 펌웨어 알림
    @Column(nullable = false)
    private boolean allowFirmwareNotification;

    // 마케팅
    @Column(nullable = false)
    private boolean allowMarketingNotification;

    public void update(UserNotificationSetting request) {
        this.allowCleaningNotification = request.allowCleaningNotification;
        this.allowProgressNotification = request.allowProgressNotification;
        this.allowDeviceNotification = request.allowDeviceNotification;
        this.allowErrorNotification = request.allowErrorNotification;
        this.allowFirmwareNotification = request.allowFirmwareNotification;
        this.allowMarketingNotification = request.allowMarketingNotification;
    }
}

