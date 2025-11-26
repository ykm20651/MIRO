package com.example.miro.domain.history.code;

import com.example.miro.global.apiPayLoad.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum HistorySuccessCode implements BaseSuccessCode {

    HISTORY_CREATED(HttpStatus.CREATED, "HIST201_1", "청소 기록 생성 완료"),
    HISTORY_LIST_FETCHED(HttpStatus.OK, "HIST200_1", "청소 기록 목록 조회 성공"),
    HISTORY_DETAIL_FETCHED(HttpStatus.OK, "HIST200_2", "청소 기록 상세 조회 성공");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
