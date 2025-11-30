package com.example.miro.domain.firmware.code;

import com.example.miro.global.apiPayLoad.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum FirmwareSuccessCode implements BaseSuccessCode {

    FIRMWARE_LATEST_FETCHED(HttpStatus.OK, "FIRM200_1", "최신 펌웨어 버전 조회 성공"),
    FIRMWARE_UPDATED(HttpStatus.CREATED, "FIRM201_1", "기기 펌웨어 업데이트 완료"),
    FIRMWARE_CREATED(HttpStatus.CREATED, "FIRM201_2", "새 펌웨어 버전 등록 완료"),
    FIRMWARE_LIST_FETCHED(HttpStatus.OK, "FIRM200_2", "펌웨어 버전 리스트 조회 성공"),
    FIRMWARE_DELETED(HttpStatus.OK, "FIRM200_3", "펌웨어 버전 삭제 완료");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
