package com.example.miro.domain.schedule.controller;

import com.example.miro.domain.schedule.code.ScheduleSuccessCode;
import com.example.miro.domain.schedule.dto.req.ScheduleReqDTO;
import com.example.miro.domain.schedule.dto.res.ScheduleResDTO;
import com.example.miro.domain.schedule.service.command.ScheduleCommandService;
import com.example.miro.domain.schedule.service.query.ScheduleQueryService;
import com.example.miro.global.apiPayLoad.ApiResponse;
import com.example.miro.global.security.CustomPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController implements ScheduleControllerDocs {

    private final ScheduleCommandService scheduleCommandService;
    private final ScheduleQueryService scheduleQueryService;

    /* 04-01 스케줄 생성 */
    @Override
    public ApiResponse<ScheduleResDTO.ScheduleInfoDTO> createSchedule(
            @AuthenticationPrincipal CustomPrincipal principal,
            @RequestBody ScheduleReqDTO.CreateScheduleDTO request
    ) {
        return ApiResponse.onSuccess(
                ScheduleSuccessCode.SCHEDULE_CREATED,
                scheduleCommandService.createSchedule(principal.getUserId(), request)
        );
    }

    /* 04-02 사용자 기기의 스케줄 목록 조회 */
    @Override
    public ApiResponse<List<ScheduleResDTO.ScheduleInfoDTO>> getSchedulesByDevice(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long userDeviceId
    ) {
        return ApiResponse.onSuccess(
                ScheduleSuccessCode.SCHEDULE_LIST_FETCHED,
                scheduleQueryService.getSchedulesByUserDevice(principal.getUserId(), userDeviceId)
        );
    }

    /* 04-03 단일 스케줄 조회 */
    @Override
    public ApiResponse<ScheduleResDTO.ScheduleInfoDTO> getSchedule(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long scheduleId
    ) {
        return ApiResponse.onSuccess(
                ScheduleSuccessCode.SCHEDULE_DETAIL_FETCHED,
                scheduleQueryService.getSchedule(principal.getUserId(), scheduleId)
        );
    }

    /* 04-04 스케줄 수정 */
    @Override
    public ApiResponse<Void> updateSchedule(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long scheduleId,
            @RequestBody ScheduleReqDTO.UpdateScheduleDTO request
    ) {
        scheduleCommandService.updateSchedule(principal.getUserId(), scheduleId, request);
        return ApiResponse.onSuccess(ScheduleSuccessCode.SCHEDULE_UPDATED);
    }

    /* 04-05 스케줄 삭제 */
    @Override
    public ApiResponse<Void> deleteSchedule(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long scheduleId
    ) {
        scheduleCommandService.deleteSchedule(principal.getUserId(), scheduleId);
        return ApiResponse.onSuccess(ScheduleSuccessCode.SCHEDULE_DELETED);
    }
}
