package com.example.miro.domain.userDevice.controller;

import com.example.miro.domain.userDevice.code.UserDeviceSuccessCode;
import com.example.miro.domain.userDevice.dto.req.UserDeviceReqDTO;
import com.example.miro.domain.userDevice.dto.res.UserDeviceResDTO;
import com.example.miro.domain.userDevice.service.command.UserDeviceCommandService;
import com.example.miro.domain.userDevice.service.query.UserDeviceQueryService;
import com.example.miro.global.apiPayLoad.ApiResponse;
import com.example.miro.global.security.CustomPrincipal;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-device")
public class UserDeviceController implements UserDeviceControllerDocs {

    private final UserDeviceCommandService userDeviceCommandService;
    private final UserDeviceQueryService userDeviceQueryService;

    /* 03-01 사용자 기기 등록 */
    @PostMapping
    @Override
    public ApiResponse<UserDeviceResDTO.UserDeviceInfoDTO> createUserDevice(
            @AuthenticationPrincipal CustomPrincipal principal,
            @Valid @RequestBody UserDeviceReqDTO.CreateUserDeviceDTO request
    ) {
        return ApiResponse.onSuccess(
                UserDeviceSuccessCode.USER_DEVICE_REGISTER_SUCCESS,
                userDeviceCommandService.createUserDevice(principal.getUserId(), request)
        );
    }

    /* 03-02 사용자 기기 목록 조회 */
    @GetMapping
    @Override
    public ApiResponse<List<UserDeviceResDTO.UserDeviceInfoDTO>> getMyDevices(
            @AuthenticationPrincipal CustomPrincipal principal
    ) {
        return ApiResponse.onSuccess(
                UserDeviceSuccessCode.USER_DEVICE_LIST_FETCH_SUCCESS,
                userDeviceQueryService.getMyDevices(principal.getUserId())
        );
    }

    /* 03-03 사용자 기기 상세 조회 */
    @GetMapping("/{userDeviceId}")
    @Override
    public ApiResponse<UserDeviceResDTO.UserDeviceInfoDTO> getMyDevice(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long userDeviceId
    ) {
        return ApiResponse.onSuccess(
                UserDeviceSuccessCode.USER_DEVICE_DETAIL_FETCH_SUCCESS,
                userDeviceQueryService.getMyDevice(principal.getUserId(), userDeviceId)
        );
    }

    /* 03-04 사용자 기기 설정 수정 */
    @PutMapping("/{userDeviceId}")
    @Override
    public ApiResponse<Void> updateUserDevice(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long userDeviceId,
            @Valid @RequestBody UserDeviceReqDTO.UpdateUserDeviceDTO request
    ) {
        userDeviceCommandService.updateUserDevice(principal.getUserId(), userDeviceId, request);
        return ApiResponse.onSuccess(UserDeviceSuccessCode.USER_DEVICE_UPDATE_SUCCESS);
    }

    /* 03-05 사용자 기기 삭제 */
    @DeleteMapping("/{userDeviceId}")
    @Override
    public ApiResponse<Void> deleteUserDevice(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long userDeviceId
    ) {
        userDeviceCommandService.deleteUserDevice(principal.getUserId(), userDeviceId);
        return ApiResponse.onSuccess(UserDeviceSuccessCode.USER_DEVICE_DELETE_SUCCESS);
    }

}
