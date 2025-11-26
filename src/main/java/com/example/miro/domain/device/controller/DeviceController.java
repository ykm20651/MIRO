package com.example.miro.domain.device.controller;

import com.example.miro.domain.device.code.DeviceSuccessCode;
import com.example.miro.domain.device.dto.req.DeviceReqDTO;
import com.example.miro.domain.device.dto.res.DeviceResDTO;
import com.example.miro.domain.device.service.command.DeviceCommandService;
import com.example.miro.domain.device.service.query.DeviceQueryService;
import com.example.miro.domain.user.enums.Role;
import com.example.miro.global.apiPayLoad.ApiResponse;
import com.example.miro.global.apiPayLoad.code.GeneralErrorCode;
import com.example.miro.global.apiPayLoad.exception.GeneralException;
import com.example.miro.global.security.CustomPrincipal;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/device")
@RequiredArgsConstructor
public class DeviceController implements DeviceControllerDocs {

    private final DeviceCommandService deviceCommandService;
    private final DeviceQueryService deviceQueryService;

    /* 02-01 기기 자체 등록 API (ADMIN만 가능) */
    @PostMapping
    @Override
    public ApiResponse<DeviceResDTO.DeviceInfoDTO> createDevice(
            @AuthenticationPrincipal CustomPrincipal principal,
            @Valid @RequestBody DeviceReqDTO.CreateDeviceDTO request
    ) {
        if (!principal.getRole().equals(Role.ADMIN)) {
            throw new GeneralException(GeneralErrorCode.FORBIDDEN);
        }

        return ApiResponse.onSuccess(
                DeviceSuccessCode.DEVICE_REGISTER_SUCCESS,
                deviceCommandService.createDevice(principal.getUserId(), request)
        );
    }

    /* 02-02 기기 상세 조회 (모든 사용자 가능) */
    @GetMapping("/{deviceId}")
    @Override
    public ApiResponse<DeviceResDTO.DeviceInfoDTO> getDevice(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long deviceId
    ) {
        return ApiResponse.onSuccess(
                DeviceSuccessCode.DEVICE_DETAIL_FETCH_SUCCESS,
                deviceQueryService.getDevice(principal.getUserId(), deviceId)
        );
    }

    /* 02-03 전체 기기 목록 조회 (모든 사용자 가능) */
    @GetMapping
    @Override
    public ApiResponse<List<DeviceResDTO.DeviceInfoDTO>> getAllDevices(
            @AuthenticationPrincipal CustomPrincipal principal
    ) {
        return ApiResponse.onSuccess(
                DeviceSuccessCode.DEVICE_LIST_FETCH_SUCCESS,
                deviceQueryService.getAllDevices(principal.getUserId())
        );
    }

    /* 02-04 기기 정보 수정 (ADMIN만 가능) */
    @PutMapping("/{deviceId}")
    @Override
    public ApiResponse<Void> updateDevice(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long deviceId,
            @Valid @RequestBody DeviceReqDTO.UpdateDeviceDTO request
    ) {
        if (!principal.getRole().equals(Role.ADMIN)) {
            throw new GeneralException(GeneralErrorCode.FORBIDDEN);
        }

        deviceCommandService.updateDevice(principal.getUserId(), deviceId, request);
        return ApiResponse.onSuccess(DeviceSuccessCode.DEVICE_UPDATE_SUCCESS);
    }

    /* 02-05 기기 삭제 (ADMIN만 가능) */
    @DeleteMapping("/{deviceId}")
    @Override
    public ApiResponse<Void> deleteDevice(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long deviceId
    ) {
        if (!principal.getRole().equals(Role.ADMIN)) {
            throw new GeneralException(GeneralErrorCode.FORBIDDEN);
        }

        deviceCommandService.deleteDevice(principal.getUserId(), deviceId);
        return ApiResponse.onSuccess(DeviceSuccessCode.DEVICE_DELETE_SUCCESS);
    }
}

