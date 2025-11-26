package com.example.miro.domain.inquiry.code;

import com.example.miro.global.apiPayLoad.code.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum InquiryErrorCode implements BaseErrorCode {

    INQUIRY_NOT_FOUND(HttpStatus.NOT_FOUND, "INQ404_1", "해당 문의를 찾을 수 없습니다."),
    USER_NOT_OWNER(HttpStatus.FORBIDDEN, "INQ403_1", "해당 문의에 접근할 권한이 없습니다."),
    INVALID_INQUIRY_TYPE(HttpStatus.BAD_REQUEST, "INQ400_1", "유효하지 않은 문의 유형입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
