package com.example.miro.domain.userDevice.code;

import com.example.miro.global.apiPayLoad.code.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserDeviceErrorCode implements BaseErrorCode {

    USER_DEVICE_NOT_FOUND(HttpStatus.NOT_FOUND, "UDEV404", "사용자-기기 연결 정보를 찾을 수 없습니다."),
    USER_DEVICE_ALREADY_REGISTERED(HttpStatus.BAD_REQUEST, "UDEV4001", "해당 기기는 이미 사용자에게 등록되어 있습니다."),
    DEVICE_NOT_REGISTERED_TO_USER(HttpStatus.BAD_REQUEST, "UDEV4002", "해당 기기는 사용자에게 등록된 기기가 아닙니다."),
    INVALID_DEFAULT_MODE(HttpStatus.BAD_REQUEST, "UDEV4003", "유효하지 않은 기본 청소 모드입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
