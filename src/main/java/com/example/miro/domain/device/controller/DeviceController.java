package com.example.miro.domain.device.controller;

import com.example.miro.domain.device.code.DeviceSuccessCode;
import com.example.miro.domain.device.dto.req.DeviceReqDTO;
import com.example.miro.domain.device.dto.res.DeviceResDTO;
import com.example.miro.domain.device.service.command.DeviceCommandService;
import com.example.miro.domain.device.service.query.DeviceQueryService;
import com.example.miro.global.apiPayLoad.ApiResponse;
import com.example.miro.global.security.CustomPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device")
@RequiredArgsConstructor
public class DeviceController implements DeviceControllerDocs {

    private final DeviceCommandService deviceCommandService;
    private final DeviceQueryService deviceQueryService;

    /* 02-01 기기 등록 API */
    @PostMapping
    @Override
    public ApiResponse<DeviceResDTO.DeviceInfoDTO> registerDevice(
            @RequestBody DeviceReqDTO.DeviceRegisterDTO dto,
            @AuthenticationPrincipal CustomPrincipal principal
    ){
        Long userId = principal.getUserId();
        return ApiResponse.onSuccess(DeviceSuccessCode.DEVICE_REGISTER_SUCCESS,
                deviceCommandService.registerDevice(userId, dto));
    }

}
