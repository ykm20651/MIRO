package com.example.miro.domain.alarm.enums;

public enum NotificationType {

    // ================================
    // Cleaning (청소 관련)
    // ================================
    CLEANING_SCHEDULE_REMINDER,   // 스케줄 시작 전 알림
    CLEANING_STARTED,             // 청소 시작
    CLEANING_PROGRESS,            // 진행률 N%
    CLEANING_PAUSED,              // 청소 일시중지
    CLEANING_RESUMED,             // 청소 재개
    CLEANING_COMPLETED,           // 청소 완료
    CLEANING_FAILED,              // 청소 실패(오류 포함)

    // ================================
    // Device (기기 상태)
    // ================================
    DEVICE_DISCONNECTED,          // 연결 끊김 (BLE/WiFi)
    DEVICE_RECONNECTED,           // 다시 연결됨
    DEVICE_BATTERY_LOW,           // 배터리 부족
    DEVICE_BATTERY_FULL,          // 충전 완료
    DEVICE_OVERHEAT,              // 과열

    // ================================
    // Errors (부품 / 오류 상태)
    // ================================
    ERROR_FILTER_DIRTY,           // 필터 청소 필요
    ERROR_DUSTBIN_FULL,           // 먼지통 가득참
    ERROR_WHEEL_STUCK,            // 휠 걸림
    ERROR_SENSOR_DIRTY,           // 센서 청소 필요
    ERROR_UNKNOWN,                // 알 수 없는 오류

    // ================================
    // Firmware / System
    // ================================
    FIRMWARE_UPDATE_AVAILABLE,    // 업데이트 가능
    FIRMWARE_UPDATE_DOWNLOADING,  // 다운로드 중
    FIRMWARE_UPDATE_READY,        // 설치 준비
    FIRMWARE_UPDATE_COMPLETED,    // 설치 완료
    FIRMWARE_UPDATE_FAILED        // 업데이트 실패
}
