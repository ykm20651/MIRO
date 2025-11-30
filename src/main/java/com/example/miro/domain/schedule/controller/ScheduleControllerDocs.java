package com.example.miro.domain.schedule.controller;

import com.example.miro.domain.schedule.dto.req.ScheduleReqDTO;
import com.example.miro.domain.schedule.dto.res.ScheduleResDTO;
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
@Tag(name = "04 Schedule", description = "04번대 스케줄(Schedule) API")
public interface ScheduleControllerDocs {

    /* 04-01 스케줄 생성 */
    @Operation(
            summary = "04-01 스케줄 생성",
            operationId = "04-01",
            description = "특정 사용자 기기(UserDevice)에 대해 반복 타입, 요일, 시간, 청소 모드를 기반으로 스케줄을 생성합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "스케줄 생성 성공 (SCH201)",
                    content = @Content(schema = @Schema(implementation = ScheduleResDTO.ScheduleInfoDTO.class))
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "해당 사용자-기기 없음 (SCH404_UD)"
            )
    })
    @PostMapping
    ApiResponse<ScheduleResDTO.ScheduleInfoDTO> createSchedule(
            @AuthenticationPrincipal CustomPrincipal principal,
            @Valid @RequestBody ScheduleReqDTO.CreateScheduleDTO request
    );


    /* 04-02 스케줄 목록 조회 */
    @Operation(
            summary = "04-02 스케줄 목록 조회",
            operationId = "04-02",
            description = "특정 사용자 기기(UserDevice)에 등록된 전체 스케줄 목록을 조회합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "스케줄 목록 조회 성공 (SCH2001)",
                    content = @Content(schema = @Schema(implementation = ScheduleResDTO.ScheduleInfoDTO.class))
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "해당 사용자-기기 없음 (SCH404_UD)"
            )
    })
    @GetMapping("/device/{userDeviceId}")
    ApiResponse<List<ScheduleResDTO.ScheduleInfoDTO>> getSchedulesByDevice(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long userDeviceId
    );


    /* 04-03 스케줄 상세 조회 */
    @Operation(
            summary = "04-03 스케줄 상세 조회",
            operationId = "04-03",
            description = "스케줄 ID를 기반으로 상세 스케줄 정보를 조회합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "스케줄 상세 조회 성공 (SCH2002)",
                    content = @Content(schema = @Schema(implementation = ScheduleResDTO.ScheduleInfoDTO.class))
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "스케줄 없음 (SCH404)"
            )
    })
    @GetMapping("/{scheduleId}")
    ApiResponse<ScheduleResDTO.ScheduleInfoDTO> getSchedule(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long scheduleId
    );


    /* 04-04 스케줄 수정 */
    @Operation(
            summary = "04-04 스케줄 수정",
            operationId = "04-04",
            description = "스케줄 ID를 기반으로 반복 타입, 요일, 시간, 청소 모드 정보를 수정합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "스케줄 수정 성공 (SCH2003)"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "스케줄 없음 (SCH404)"
            )
    })
    @PutMapping("/{scheduleId}")
    ApiResponse<Void> updateSchedule(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long scheduleId,
            @Valid @RequestBody ScheduleReqDTO.UpdateScheduleDTO request
    );


    /* 04-05 스케줄 삭제 */
    @Operation(
            summary = "04-05 스케줄 삭제",
            operationId = "04-05",
            description = "스케줄 ID를 기반으로 해당 스케줄을 삭제합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "204",
                    description = "스케줄 삭제 성공 (SCH204)"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "스케줄 없음 (SCH404)"
            )
    })
    @DeleteMapping("/{scheduleId}")
    ApiResponse<Void> deleteSchedule(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long scheduleId
    );
}
