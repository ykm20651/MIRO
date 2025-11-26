package com.example.miro.domain.userDevice.code;

import com.example.miro.global.apiPayLoad.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserDeviceSuccessCode implements BaseSuccessCode {

    USER_DEVICE_REGISTER_SUCCESS(
            HttpStatus.CREATED,
            "USER_DEVICE201_1",
            "사용자 기기 등록이 완료되었습니다."
    ),

    USER_DEVICE_LIST_FETCH_SUCCESS(
            HttpStatus.OK,
            "USER_DEVICE200_1",
            "사용자의 기기 목록 조회가 완료되었습니다."
    ),

    USER_DEVICE_DETAIL_FETCH_SUCCESS(
            HttpStatus.OK,
            "USER_DEVICE200_2",
            "사용자 기기 상세 조회가 완료되었습니다."
    ),

    USER_DEVICE_UPDATE_SUCCESS(
            HttpStatus.OK,
            "USER_DEVICE200_3",
            "사용자 기기 설정이 수정되었습니다."
    ),

    USER_DEVICE_DELETE_SUCCESS(
            HttpStatus.NO_CONTENT,
            "USER_DEVICE204_1",
            "사용자 기기 연결이 삭제되었습니다."
    );

    private final HttpStatus status;
    private final String code;
    private final String message;
}
