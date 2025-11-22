package com.example.miro.domain.user.exception;

import com.example.miro.global.apiPayLoad.code.BaseErrorCode;
import com.example.miro.global.apiPayLoad.exception.GeneralException;

public class UserException extends GeneralException {
    public UserException(BaseErrorCode code) {
        super(code);
    }
}
