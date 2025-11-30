package com.example.miro.domain.firmware.controller;

import com.example.miro.domain.firmware.dto.req.FirmwareReqDTO;
import com.example.miro.domain.firmware.dto.res.FirmwareResDTO;
import com.example.miro.global.apiPayLoad.ApiResponse;
import com.example.miro.global.security.CustomPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "07 Firmware", description = "07번대 펌웨어(Firmware) API")
public interface FirmwareControllerDocs {

    /* 07-01 최신 버전 조회 */
    @Operation(
            summary = "07-01 최신 버전 조회 (USER)",
            operationId = "07-01",
            description = "특정 모델명의 최신 펌웨어 버전을 조회합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "최신 펌웨어 조회 성공",
                    content = @Content(schema = @Schema(implementation = FirmwareResDTO.LatestFirmwareDTO.class))
            )
    })
    @GetMapping("/latest/{modelName}")
    ApiResponse<FirmwareResDTO.LatestFirmwareDTO> getLatestFirmware(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable String modelName
    );



    /* 07-02 기기 업데이트 (USER) */
    @Operation(
            summary = "07-02 기기 업데이트",
            operationId = "07-02",
            description = "사용 중인 기기의 펌웨어를 최신 버전으로 업데이트합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "기기 업데이트 성공 (FW2011)"
            )
    })
    @PostMapping("/update")
    ApiResponse<Void> updateFirmware(
            @AuthenticationPrincipal CustomPrincipal principal,
            @RequestBody FirmwareReqDTO.UpdateRequestDTO request
    );


    /* 07-03 새 버전 등록 (ADMIN) */
    @Operation(
            summary = "07-03 새 버전 등록 (ADMIN)",
            operationId = "07-03",
            description = "ADMIN이 새로운 펌웨어 버전을 등록합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "펌웨어 등록 성공 (FW2012)",
                    content = @Content(schema = @Schema(implementation = FirmwareResDTO.FirmwareInfoDTO.class))
            )
    })
    @PostMapping
    ApiResponse<FirmwareResDTO.FirmwareInfoDTO> createFirmware(
            @AuthenticationPrincipal CustomPrincipal principal,
            @RequestBody FirmwareReqDTO.RegisterFirmwareDTO request
    );


    /* 07-04 버전 리스트 조회 (ADMIN) */
    @Operation(
            summary = "07-04 버전 리스트 조회 (ADMIN)",
            operationId = "07-04",
            description = "등록된 모든 펌웨어 버전 목록을 조회합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "조회 성공 (FW2002)"
            )
    })
    @GetMapping
    ApiResponse<List<FirmwareResDTO.FirmwareInfoDTO>> getFirmwareList(
            @AuthenticationPrincipal CustomPrincipal principal
    );


    /* 07-05 버전 삭제 (ADMIN) */
    @Operation(
            summary = "07-05 버전 삭제 (ADMIN)",
            operationId = "07-05",
            description = "특정 펌웨어 버전을 삭제합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "삭제 성공 (FW2003)"
            )
    })
    @DeleteMapping("/{firmwareId}")
    ApiResponse<Void> deleteFirmware(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long firmwareId
    );
}
