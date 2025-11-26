package com.example.miro.domain.firmware.code;

import com.example.miro.global.apiPayLoad.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum FirmwareSuccessCode implements BaseSuccessCode {

    FIRMWARE_LATEST_FETCHED(HttpStatus.OK, "FIRM200_1", "최신 펌웨어 버전 조회 성공"),
    FIRMWARE_UPDATE_LOG_CREATED(HttpStatus.CREATED, "FIRM201_1", "펌웨어 업데이트 기록 생성 완료");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
