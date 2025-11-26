package com.example.miro.domain.firmware.exception;

import com.example.miro.global.apiPayLoad.code.BaseErrorCode;
import com.example.miro.global.apiPayLoad.exception.GeneralException;

public class FirmwareException extends GeneralException {
    public FirmwareException(BaseErrorCode code) {
        super(code);
    }
}
