package com.example.miro.domain.userDevice.code;

import com.example.miro.global.apiPayLoad.code.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserDeviceErrorCode implements BaseErrorCode {

    USER_DEVICE_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "USER_DEVICE404_1",
            "사용자-기기 연결 정보를 찾을 수 없습니다."
    ),

    USER_DEVICE_ALREADY_REGISTERED(
            HttpStatus.CONFLICT,
            "USER_DEVICE409_1",
            "이미 사용자에게 등록된 기기입니다."
    ),

    DEVICE_NOT_OWNED_BY_USER(
            HttpStatus.BAD_REQUEST,
            "USER_DEVICE400_1",
            "해당 기기는 사용자에게 등록된 기기가 아닙니다."
    ),

    INVALID_DEFAULT_MODE(
            HttpStatus.BAD_REQUEST,
            "USER_DEVICE400_2",
            "유효하지 않은 기본 청소 모드입니다."
    );

    private final HttpStatus status;
    private final String code;
    private final String message;
}
