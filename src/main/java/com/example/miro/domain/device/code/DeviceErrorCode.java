package com.example.miro.domain.device.code;

import com.example.miro.global.apiPayLoad.code.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum DeviceErrorCode implements BaseErrorCode {
    DEVICE_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "D401",
            "해당 기기를 찾을 수 없습니다."
    ),

    DEVICE_ALREADY_REGISTERED(
            HttpStatus.CONFLICT,
            "D402",
            "해당 기기는 이미 사용자에게 등록되어 있습니다."
    ),

    DEVICE_SERIAL_REQUIRED(
            HttpStatus.BAD_REQUEST,
            "D403",
            "기기 시리얼 번호는 반드시 필요합니다."
    ),

    DEVICE_MODEL_REQUIRED(
            HttpStatus.BAD_REQUEST,
            "D404",
            "기기 모델명은 반드시 필요합니다."
    ),

    DEVICE_FIRMWARE_REQUIRED(
            HttpStatus.BAD_REQUEST,
            "D405",
            "펌웨어 버전은 반드시 필요합니다."
    );

    private final HttpStatus status;
    private final String code;
    private final String message;
}
