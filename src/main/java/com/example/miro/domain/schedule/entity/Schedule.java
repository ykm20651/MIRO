package com.example.miro.domain.schedule.entity;

import com.example.miro.domain.schedule.enums.RepeatType;
import com.example.miro.domain.userDevice.entity.UserDevice;
import com.example.miro.domain.userDevice.enums.CleanMode;
import com.example.miro.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userDevice_id")
    private UserDevice userDevice;

    @Enumerated(EnumType.STRING)
    @Column(name = "repeatType", nullable = false, length = 20)
    private RepeatType repeatType;

    @Column(name = "day", length = 255)
    private String day; // MON,TUE,WED

    @Column(name = "time", nullable = false)
    private String time;

    @Column(name = "memo", nullable = true)
    private String memo;

    @Enumerated(EnumType.STRING)
    @Column(name = "mode", nullable = false, length = 20)
    private CleanMode mode;

    public void updateSchedule(RepeatType repeatType, String day, String time, CleanMode mode) {

        this.repeatType = repeatType;
        this.day = day;
        this.time = time;
        this.mode = mode;
    }

}
