package com.example.miro.domain.schedule.service.query;

import com.example.miro.domain.schedule.dto.res.ScheduleResDTO;

import java.util.List;

public interface ScheduleQueryService {


    /* 04-02 특정 유저의 특정 기기에 대한 스케줄 전체 조회 */
    List<ScheduleResDTO.ScheduleInfoDTO> getSchedulesByUserDevice(Long userId, Long userDeviceId);

    /* 04-03: 스케줄 상세 조회 */
    ScheduleResDTO.ScheduleInfoDTO getSchedule(Long userId, Long scheduleId);
}
