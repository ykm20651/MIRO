package com.example.miro.domain.schedule.service.command;

import com.example.miro.domain.schedule.dto.req.ScheduleReqDTO;
import com.example.miro.domain.schedule.dto.res.ScheduleResDTO;

public interface ScheduleCommandService {
    /* 04-01 스케줄 생성 */
    ScheduleResDTO.ScheduleInfoDTO createSchedule(Long userId, ScheduleReqDTO.CreateScheduleDTO request);

    /* 04-04 스케줄 수정 */
    void updateSchedule(Long userId, Long scheduleId, ScheduleReqDTO.UpdateScheduleDTO request);

    /* 04-05 스케줄 삭제 */
    void deleteSchedule(Long userId, Long scheduleId);
}
