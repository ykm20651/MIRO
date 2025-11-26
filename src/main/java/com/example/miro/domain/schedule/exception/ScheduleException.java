package com.example.miro.domain.schedule.exception;

import com.example.miro.global.apiPayLoad.code.BaseErrorCode;
import com.example.miro.global.apiPayLoad.exception.GeneralException;

public class ScheduleException extends GeneralException {
    public ScheduleException(BaseErrorCode code) {
        super(code);
    }
}
