package com.example.miro.domain.firmware.controller;

import com.example.miro.domain.firmware.code.FirmwareSuccessCode;
import com.example.miro.domain.firmware.dto.req.FirmwareReqDTO;
import com.example.miro.domain.firmware.dto.res.FirmwareResDTO;
import com.example.miro.domain.firmware.service.command.FirmwareCommandService;
import com.example.miro.domain.firmware.service.query.FirmwareQueryService;
import com.example.miro.global.apiPayLoad.ApiResponse;
import com.example.miro.global.security.CustomPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/firmware")
public class FirmwareController implements FirmwareControllerDocs {

    private final FirmwareCommandService firmwareCommandService;
    private final FirmwareQueryService firmwareQueryService;


    /* 07-01 최신 버전 조회 */
    @Override
    public ApiResponse<FirmwareResDTO.LatestFirmwareDTO> getLatestFirmware(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable String modelName
    ) {
        return ApiResponse.onSuccess(
                FirmwareSuccessCode.FIRMWARE_LATEST_FETCHED,
                firmwareQueryService.getLatestFirmware(modelName)
        );
    }



    /* 07-02 기기 업데이트 */
    @Override
    public ApiResponse<Void> updateFirmware(
            @AuthenticationPrincipal CustomPrincipal principal,
            @RequestBody FirmwareReqDTO.UpdateRequestDTO request
    ) {
        firmwareCommandService.updateFirmware(principal.getUserId(), request);
        return ApiResponse.onSuccess(FirmwareSuccessCode.FIRMWARE_UPDATED);
    }


    /* 07-03 새 버전 등록 (ADMIN) */
    @Override
    public ApiResponse<FirmwareResDTO.FirmwareInfoDTO> createFirmware(
            @AuthenticationPrincipal CustomPrincipal principal,
            @RequestBody FirmwareReqDTO.RegisterFirmwareDTO request
    ) {
        return ApiResponse.onSuccess(
                FirmwareSuccessCode.FIRMWARE_CREATED,
                firmwareCommandService.createFirmware(request)
        );
    }


    /* 07-04 버전 리스트 */
    @Override
    public ApiResponse<List<FirmwareResDTO.FirmwareInfoDTO>> getFirmwareList(
            @AuthenticationPrincipal CustomPrincipal principal
    ) {
        return ApiResponse.onSuccess(
                FirmwareSuccessCode.FIRMWARE_LIST_FETCHED,
                firmwareQueryService.getFirmwareList()
        );
    }


    /* 07-05 버전 삭제 */
    @Override
    public ApiResponse<Void> deleteFirmware(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long firmwareId
    ) {
        firmwareCommandService.deleteFirmware(firmwareId);
        return ApiResponse.onSuccess(FirmwareSuccessCode.FIRMWARE_DELETED);
    }
}
