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


    //개별 기기 고유 값 (사용자가 구매한 실제 기기)
    @Column(name = "serialNumber", nullable = false, length = 255)
    private String serialNumber; //기기 자체를 여러 유저들이 구매할 수 있는데, 그 자체 시리얼 넘버가 다르게 할 것임.

    //제품 모델 계열(Galaxy S25와 같은 개념)
    //동일한 modelName을 가진 여러 firmwareVersion이 존재할 수 있음.
    //Firmware 테이블은 “그 모델의 최신 버전 정보를 저장”하는 용도임.
    @Column(name = "modelName", nullable = false, length = 40)
    private String modelName; //이건 모델 명 자체 -> 갤럭시 S25처럼, 로봇 모델명.

    @Column(name = "firmwareVersion", nullable = false, length = 255)
    private String firmwareVersion;

    /*
    serialNumber : 사용자마다 다른 기기 고유값
    modelName : 기기 종류(MIRO_R1, MIRO_R2 등)
    firmwareVersion : 이 기기가 현재 사용 중인 버전
    */

    public void updateFirmwareVersion(String newVersion) {
        this.firmwareVersion = newVersion;
    }
}
