package com.example.miro.domain.schedule.code;

import com.example.miro.global.apiPayLoad.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ScheduleSuccessCode implements BaseSuccessCode {

    SCHEDULE_CREATED(HttpStatus.CREATED, "SCH201_1", "스케줄 생성 완료"),
    SCHEDULE_UPDATED(HttpStatus.OK, "SCH200_1", "스케줄 수정 완료"),
    SCHEDULE_DELETED(HttpStatus.NO_CONTENT, "SCH204_1", "스케줄 삭제 완료"),
    SCHEDULE_LIST_FETCHED(HttpStatus.OK, "SCH200_2", "스케줄 목록 조회 성공"),
    SCHEDULE_DETAIL_FETCHED(HttpStatus.OK, "SCH200_3", "스케줄 상세 조회 성공");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
