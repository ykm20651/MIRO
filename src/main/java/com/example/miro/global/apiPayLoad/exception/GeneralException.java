package com.example.miro.global.apiPayLoad.exception;

import com.example.miro.global.apiPayLoad.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private final BaseErrorCode code;
}