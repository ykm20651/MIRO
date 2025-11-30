package com.example.miro.domain.schedule.converter;

import com.example.miro.domain.schedule.dto.req.ScheduleReqDTO;
import com.example.miro.domain.schedule.dto.res.ScheduleResDTO;
import com.example.miro.domain.schedule.entity.Schedule;
import com.example.miro.domain.userDevice.entity.UserDevice;

public class ScheduleConverter {

    public static Schedule toSchedule(UserDevice userDevice, ScheduleReqDTO.CreateScheduleDTO request) {
        return Schedule.builder()
                .userDevice(userDevice)
                .repeatType(request.getRepeatType())
                .day(request.getDay())
                .time(request.getTime())
                .mode(request.getMode())
                .build();
    }

    public static ScheduleResDTO.ScheduleInfoDTO toScheduleInfoDTO(Schedule schedule) {
        return ScheduleResDTO.ScheduleInfoDTO.builder()
                .scheduleId(schedule.getId())
                .userDeviceId(schedule.getUserDevice().getId())
                .repeatType(schedule.getRepeatType())
                .day(schedule.getDay())
                .time(schedule.getTime())
                .mode(schedule.getMode())
                .build();
    }
}
