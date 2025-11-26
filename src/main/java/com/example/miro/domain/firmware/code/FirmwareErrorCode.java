package com.example.miro.domain.firmware.code;

import com.example.miro.global.apiPayLoad.code.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum FirmwareErrorCode implements BaseErrorCode {

    FIRMWARE_NOT_FOUND(HttpStatus.NOT_FOUND, "FIRM404_1", "해당 펌웨어 정보를 찾을 수 없습니다."),
    FIRMWARE_MODEL_NOT_SUPPORTED(HttpStatus.BAD_REQUEST, "FIRM400_1", "지원하지 않는 모델의 펌웨어입니다."),
    FIRMWARE_DOWNLOAD_URL_INVALID(HttpStatus.BAD_REQUEST, "FIRM400_2", "펌웨어 다운로드 URL이 유효하지 않습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
