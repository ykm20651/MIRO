package com.example.miro.domain.inquiry.code;

import com.example.miro.global.apiPayLoad.code.BaseSuccessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum InquirySuccessCode implements BaseSuccessCode {

    INQUIRY_CREATED(HttpStatus.CREATED, "INQ201_1", "문의 작성 완료"),
    INQUIRY_LIST_FETCHED(HttpStatus.OK, "INQ200_1", "문의 목록 조회 성공"),
    INQUIRY_DETAIL_FETCHED(HttpStatus.OK, "INQ200_2", "문의 상세 조회 성공");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
