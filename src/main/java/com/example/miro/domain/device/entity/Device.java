package com.example.miro.domain.device.entity;

import com.example.miro.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "device")
public class Device extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firmwareId", nullable = false)
    private Long firmwareId;

    @Column(name = "serialNumber", nullable = false, length = 255)
    private String serialNumber;

    @Column(name = "modelName", nullable = false, length = 40)
    private String modelName;

    @Column(name = "firmwareVersion", nullable = false, length = 255)
    private String firmwareVersion;
}
