package com.example.miro.domain.userDevice.controller;

import com.example.miro.domain.userDevice.dto.req.UserDeviceReqDTO;
import com.example.miro.domain.userDevice.dto.res.UserDeviceResDTO;
import com.example.miro.global.apiPayLoad.ApiResponse;
import com.example.miro.global.security.CustomPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserDeviceControllerDocs {

    /* 03-01 사용자 기기 등록 */
    @Operation(summary = "03-01 사용자 기기 등록", description = "로그인한 사용자의 계정에 새로운 기기를 등록합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "등록 성공 (UDEV201)",
                    content = @Content(schema = @Schema(implementation = UserDeviceResDTO.UserDeviceInfoDTO.class))
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "400",
                    description = "이미 등록된 기기 (UDEV4001)"
            )
    })
    @PostMapping
    ApiResponse<UserDeviceResDTO.UserDeviceInfoDTO> createUserDevice(
            @AuthenticationPrincipal CustomPrincipal principal,
            @Valid @RequestBody UserDeviceReqDTO.CreateUserDeviceDTO request
    );

    /* 03-02 사용자 기기 목록 조회 */
    @Operation(summary = "03-02 내 기기 목록 조회", description = "로그인한 사용자가 등록한 모든 기기를 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "조회 성공 (UDEV2002)"
            )
    })
    @GetMapping
    ApiResponse<List<UserDeviceResDTO.UserDeviceInfoDTO>> getMyDevices(
            @AuthenticationPrincipal CustomPrincipal principal
    );

    /* 03-03 사용자 기기 상세 조회 */
    @Operation(summary = "03-03 내 기기 상세 조회", description = "로그인한 사용자가 소유한 특정 기기의 상세 정보를 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "조회 성공 (UDEV2003)"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "해당 사용자 기기 없음 (UDEV404)"
            )
    })
    @GetMapping("/{userDeviceId}")
    ApiResponse<UserDeviceResDTO.UserDeviceInfoDTO> getMyDevice(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long userDeviceId
    );

    /* 03-04 사용자 기기 설정 수정 */
    @Operation(summary = "03-04 사용자 기기 설정 수정", description = "기본 청소 모드, 자동 청소 여부 등 기기 설정을 수정합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "수정 성공 (UDEV200)"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "기기 없음 (UDEV404)")
    })
    @PutMapping("/{userDeviceId}")
    ApiResponse<Void> updateUserDevice(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long userDeviceId,
            @Valid @RequestBody UserDeviceReqDTO.UpdateUserDeviceDTO request
    );

    /* 03-05 사용자 기기 삭제 */
    @Operation(summary = "03-05 사용자 기기 삭제", description = "연동된 사용자 기기를 계정에서 삭제합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "삭제 성공 (UDEV204)"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "기기 없음 (UDEV404)")
    })
    @DeleteMapping("/{userDeviceId}")
    ApiResponse<Void> deleteUserDevice(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long userDeviceId
    );
}
