package com.example.miro.global.apiPayLoad.code;

import org.springframework.http.HttpStatus;

public interface BaseSuccessCode {

    HttpStatus getStatus();
    String getCode();
    String getMessage();
}
