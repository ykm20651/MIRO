package com.example.miro.domain.userDevice.exception;

import com.example.miro.global.apiPayLoad.code.BaseErrorCode;
import com.example.miro.global.apiPayLoad.exception.GeneralException;

public class UserDeviceException extends GeneralException {

    public UserDeviceException(BaseErrorCode code){
        super(code);
    }
}
