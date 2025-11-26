package com.example.miro.domain.userDevice.entity;

import com.example.miro.domain.device.entity.Device;
import com.example.miro.domain.schedule.entity.Schedule;
import com.example.miro.domain.user.entity.User;
import com.example.miro.domain.userDevice.enums.CleanMode;
import com.example.miro.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "user_device")
public class UserDevice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    @Enumerated(EnumType.STRING)
    @Column(name = "defaultMode", nullable = false, length = 20)
    private CleanMode defaultMode;

    @Column(name = "autoCleanEnabled", nullable = false)
    private boolean autoCleanEnabled;

    @Column(name = "lastConnectedAt")
    private LocalDateTime lastConnectedAt;

    @Column(name = "isInitialized", nullable = false)
    private boolean isInitialized;

    @OneToMany(mappedBy = "userDevice", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Schedule> schedules = new ArrayList<>();

}
