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
            "DEVICE201_1",
            "기기 등록이 완료되었습니다."
    ),

    DEVICE_LIST_FETCH_SUCCESS(
            HttpStatus.OK,
            "DEVICE200_1",
            "기기 목록 조회가 완료되었습니다."
    ),

    DEVICE_DETAIL_FETCH_SUCCESS(
            HttpStatus.OK,
            "DEVICE200_2",
            "기기 상세 조회가 완료되었습니다."
    ),

    DEVICE_UPDATE_SUCCESS(
            HttpStatus.OK,
            "DEVICE200_3",
            "기기 정보 수정이 완료되었습니다."
    ),

    DEVICE_DELETE_SUCCESS(
            HttpStatus.OK,
            "DEVICE200_4",
            "기기 연결이 해제되었습니다."
    );

    private final HttpStatus status;
    private final String code;
    private final String message;
}
