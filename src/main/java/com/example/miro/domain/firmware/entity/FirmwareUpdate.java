package com.example.miro.domain.firmware.entity;

import com.example.miro.domain.firmware.enums.FirmwareUpdateStatus;
import com.example.miro.domain.device.entity.Device;
import com.example.miro.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "firmware_update")
public class FirmwareUpdate extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    private Device device;

    @Column(name= "beforeVersion", nullable = false, length = 255)
    private String beforeVersion;

    @Column(name = "afterVersion", nullable = false, length = 255)
    private String afterVersion;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private FirmwareUpdateStatus status;
}
