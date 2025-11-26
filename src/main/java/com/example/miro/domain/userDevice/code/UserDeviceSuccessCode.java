package com.example.miro.domain.userDevice.code;

import com.example.miro.global.apiPayLoad.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserDeviceSuccessCode implements BaseSuccessCode {

    USER_DEVICE_REGISTERED(HttpStatus.CREATED, "UDEV201", "사용자 기기 등록이 완료되었습니다."),
    USER_DEVICE_DELETED(HttpStatus.NO_CONTENT, "UDEV204", "사용자 기기 연결이 정상적으로 삭제되었습니다."),
    USER_DEVICE_UPDATED(HttpStatus.OK, "UDEV200", "사용자 기기 설정이 수정되었습니다."),
    USER_DEVICE_LIST_FETCHED(HttpStatus.OK, "UDEV2002", "사용자의 기기 목록 조회가 완료되었습니다."),
    USER_DEVICE_DETAIL_FETCHED(HttpStatus.OK, "UDEV2003", "기기 상세 정보 조회가 완료되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

}
