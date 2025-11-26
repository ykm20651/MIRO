package com.example.miro.domain.inquiry.exception;

import com.example.miro.global.apiPayLoad.code.BaseErrorCode;
import com.example.miro.global.apiPayLoad.exception.GeneralException;

public class InquiryException extends GeneralException {
    public InquiryException(BaseErrorCode code) {
        super(code);
    }
}
