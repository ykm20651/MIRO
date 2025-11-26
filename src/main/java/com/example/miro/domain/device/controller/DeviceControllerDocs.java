package com.example.miro.domain.device.controller;

import com.example.miro.domain.device.dto.req.DeviceReqDTO;
import com.example.miro.domain.device.dto.res.DeviceResDTO;
import com.example.miro.global.apiPayLoad.ApiResponse;
import com.example.miro.global.security.CustomPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface DeviceControllerDocs {
    /* 02-01 기기 등록 API */
    @PostMapping
    ApiResponse<DeviceResDTO.DeviceInfoDTO> registerDevice(
            @RequestBody DeviceReqDTO.DeviceRegisterDTO dto,
            @AuthenticationPrincipal CustomPrincipal principal
    );
}
