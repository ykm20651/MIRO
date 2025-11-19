package com.example.miro.domain.firmware.entity;

import com.example.miro.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "firmware")
public class Firmware extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name ="modelName", nullable = false, length = 255)
    private String modelName;

    @Column(name = "latestVersion", nullable = false, length = 255)
    private String latestVersion;

    @Column(name = "downloadUrl", nullable = false, length = 255)
    private String downloadUrl;
}
