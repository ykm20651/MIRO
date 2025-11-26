package com.example.miro.domain.schedule.code;

import com.example.miro.global.apiPayLoad.code.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ScheduleErrorCode implements BaseErrorCode {

    SCHEDULE_NOT_FOUND(HttpStatus.NOT_FOUND, "SCH404_1", "해당 스케줄을 찾을 수 없습니다."),
    INVALID_REPEAT_TYPE(HttpStatus.BAD_REQUEST, "SCH400_1", "유효하지 않은 반복 타입입니다."),
    INVALID_DAY_FORMAT(HttpStatus.BAD_REQUEST, "SCH400_2", "요일 형식이 유효하지 않습니다."),
    USER_DEVICE_NOT_MATCH(HttpStatus.FORBIDDEN, "SCH403_1", "해당 스케줄에 접근할 권한이 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
