package com.example.miro.domain.history.code;

import com.example.miro.global.apiPayLoad.code.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum HistoryErrorCode implements BaseErrorCode {

    HISTORY_NOT_FOUND(HttpStatus.NOT_FOUND, "HIST404_1", "해당 청소 기록을 찾을 수 없습니다."),
    USER_DEVICE_NOT_MATCH(HttpStatus.FORBIDDEN, "HIST403_1", "해당 기록에 접근할 권한이 없습니다."),
    INVALID_HISTORY_STATUS(HttpStatus.BAD_REQUEST, "HIST400_1", "유효하지 않은 청소 기록 상태입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
