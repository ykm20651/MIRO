package com.example.miro.domain.history.entity;


import com.example.miro.domain.history.enums.HistoryStatus;
import com.example.miro.domain.userDevice.entity.UserDevice;
import com.example.miro.domain.userDevice.enums.CleanMode;
import com.example.miro.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "history")
public class History extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userDevice_id")
    private UserDevice userDevice;

    @Enumerated(EnumType.STRING)
    @Column(name = "mode", nullable = false, length = 20)
    private CleanMode mode;

    @Column(name = "startedAt", nullable = false)
    private LocalDateTime startedAt;

    @Column(name = "endedAt", nullable = false)
    private LocalDateTime endedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private HistoryStatus status;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "batteryUsage", nullable = false)
    private int batteryUsage;

    @Column(name = "areaSize", nullable = false)
    private int areaSize;
}
