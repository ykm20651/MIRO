package com.example.miro.domain.history.controller;

import com.example.miro.domain.history.dto.req.HistoryReqDTO;
import com.example.miro.domain.history.dto.res.HistoryResDTO;
import com.example.miro.global.apiPayLoad.ApiResponse;
import com.example.miro.global.security.CustomPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "05 History", description = "05번대 청소 기록(History) API")
public interface HistoryControllerDocs {

    /* 05-01 청소 기록 업로드 */
    @Operation(
            summary = "05-01 청소 기록 업로드",
            operationId = "05-01",
            description = "로봇이 청소를 완료했을 때, 청소 결과 데이터(duration, 면적, 배터리 소모, 상태 등)을 업로드합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "청소 기록 업로드 성공 (HIST201_1)",
                    content = @Content(schema = @Schema(implementation = HistoryResDTO.HistoryInfoDTO.class))
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "해당 사용자-기기 없음 (UD404_1)"
            )
    })
    @PostMapping
    ApiResponse<HistoryResDTO.HistoryInfoDTO> createHistory(
            @AuthenticationPrincipal CustomPrincipal principal,
            @Valid @RequestBody HistoryReqDTO.CreateHistoryDTO request
    );



    /* 05-02 기록 목록 조회 */
    @Operation(
            summary = "05-02 청소 기록 목록 조회 (특정 기기)",
            operationId = "05-02",
            description = "특정 사용자 기기(UserDevice)에 대해 저장된 모든 청소 기록 목록을 조회합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "기록 목록 조회 성공 (HIST200_1)",
                    content = @Content(schema = @Schema(implementation = HistoryResDTO.HistoryInfoDTO.class))
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "해당 사용자-기기 없음 (UD404_1)"
            )
    })
    @GetMapping("/device/{userDeviceId}")
    ApiResponse<List<HistoryResDTO.HistoryInfoDTO>> getHistoryList(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long userDeviceId
    );



    /* 05-03 기록 상세 조회 */
    @Operation(
            summary = "05-03 단일 청소 기록 상세 조회",
            operationId = "05-03",
            description = "청소 기록 ID를 기반으로 해당 기록의 상세 정보(시간/면적/배터리 소모/상태 등)를 조회합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "기록 상세 조회 성공 (HIST200_2)",
                    content = @Content(schema = @Schema(implementation = HistoryResDTO.HistoryInfoDTO.class))
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "청소 기록 없음 (HIST404_1)"
            )
    })
    @GetMapping("/{historyId}")
    ApiResponse<HistoryResDTO.HistoryInfoDTO> getHistory(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long historyId
    );
}
