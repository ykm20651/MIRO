package com.example.miro.domain.device.exception;

import com.example.miro.global.apiPayLoad.code.BaseErrorCode;
import com.example.miro.global.apiPayLoad.exception.GeneralException;

public class DeviceException extends GeneralException {
    public DeviceException(BaseErrorCode code) {
        super(code);
    }
}
