package com.example.miro.domain.device.code;

import com.example.miro.global.apiPayLoad.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum DeviceSuccessCode implements BaseSuccessCode {

    DEVICE_REGISTER_SUCCESS(
            HttpStatus.CREATED,
            "D001",
            "기기 등록이 완료되었습니다."
    ),

    DEVICE_LIST_FETCH_SUCCESS(
            HttpStatus.OK,
            "D002",
            "기기 목록 조회가 완료되었습니다."
    ),

    DEVICE_DETAIL_FETCH_SUCCESS(
            HttpStatus.OK,
            "D003",
            "기기 상세 조회가 완료되었습니다."
    ),

    DEVICE_DELETE_SUCCESS(
            HttpStatus.OK,
            "D004",
            "기기 연결이 해제되었습니다."
    );
    private final HttpStatus status;
    private final String code;
    private final String message;
}
