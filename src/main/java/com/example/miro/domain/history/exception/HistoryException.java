package com.example.miro.domain.history.exception;

import com.example.miro.global.apiPayLoad.code.BaseErrorCode;
import com.example.miro.global.apiPayLoad.exception.GeneralException;

public class HistoryException extends GeneralException {
    public HistoryException(BaseErrorCode code) {
        super(code);
    }
}
