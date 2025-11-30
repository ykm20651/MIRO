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

    //동일한 modelName을 가진 여러 firmwareVersion이 존재할 수 있음.
    //Firmware 테이블은 “그 모델의 최신 버전 정보를 저장”하는 용도임.
    /* 이 모델은 각 모델마다 최신 버전만 저장하는 단일 Row 구조 */
    // Firmware = 항상 최신 버전만 저장하는 구조
    // FirmwareUpdate = 구버전 이력 관리
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
