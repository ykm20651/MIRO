package com.example.miro.domain.device.controller;

import com.example.miro.domain.device.dto.req.DeviceReqDTO;
import com.example.miro.domain.device.dto.res.DeviceResDTO;
import com.example.miro.global.apiPayLoad.ApiResponse;
import com.example.miro.global.security.CustomPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface DeviceControllerDocs {

    /* 02-01 기기 등록 (ADMIN만 가능) */
    @Operation(
            summary = "02-01 기기 등록 (ADMIN)",
            description = "시리얼번호/모델명/펌웨어 버전을 기반으로 기기를 등록합니다. (ADMIN 권한 필요)"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "기기 등록 성공 (DEVICE201_1)",
                    content = @Content(schema = @Schema(implementation = DeviceResDTO.DeviceInfoDTO.class))
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "403",
                    description = "권한 없음 (COMMON403_1)"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "409",
                    description = "이미 존재하는 시리얼 번호 (DEVICE409_1)"
            )
    })
    @PostMapping
    ApiResponse<DeviceResDTO.DeviceInfoDTO> createDevice(
            @AuthenticationPrincipal CustomPrincipal principal,
            @RequestBody DeviceReqDTO.CreateDeviceDTO request
    );



    /* 02-02 기기 상세 조회 */
    @Operation(
            summary = "02-02 기기 상세 조회",
            description = "특정 기기 상세 정보를 조회합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "기기 조회 성공 (DEVICE200_2)"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "기기 없음 (DEVICE404_1)"
            )
    })
    @GetMapping("/{deviceId}")
    ApiResponse<DeviceResDTO.DeviceInfoDTO> getDevice(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long deviceId
    );



    /* 02-03 전체 기기 목록 조회 */
    @Operation(
            summary = "02-03 전체 기기 목록 조회",
            description = "등록된 전체 기기 목록을 조회합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "목록 조회 성공 (DEVICE200_1)"
            )
    })
    @GetMapping
    ApiResponse<List<DeviceResDTO.DeviceInfoDTO>> getAllDevices(
            @AuthenticationPrincipal CustomPrincipal principal
    );



    /* 02-04 기기 정보 수정 (ADMIN) */
    @Operation(
            summary = "02-04 기기 정보 수정 (ADMIN)",
            description = "기기의 모델명/펌웨어 버전을 수정합니다. (ADMIN 권한 필요)"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "수정 성공 (DEVICE200_3)"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "403",
                    description = "권한 없음 (COMMON403_1)"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "기기 없음 (DEVICE404_1)"
            )
    })
    @PutMapping("/{deviceId}")
    ApiResponse<Void> updateDevice(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long deviceId,
            @RequestBody DeviceReqDTO.UpdateDeviceDTO request
    );



    /* 02-05 기기 삭제 (ADMIN) */
    @Operation(
            summary = "02-05 기기 삭제 (ADMIN)",
            description = "기기 정보를 삭제합니다. (ADMIN 권한 필요)"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "삭제 성공 (DEVICE200_4)"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "403",
                    description = "권한 없음 (COMMON403_1)"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "기기 없음 (DEVICE404_1)"
            )
    })
    @DeleteMapping("/{deviceId}")
    ApiResponse<Void> deleteDevice(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long deviceId
    );
}
