package com.example.miro.domain.schedule.dto.res;

import com.example.miro.domain.schedule.enums.RepeatType;
import com.example.miro.domain.userDevice.enums.CleanMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class ScheduleResDTO {

    @Getter
    @Builder
    @AllArgsConstructor //DTO Projection 때문에 생성자 어노테이션 붙임.
    public static class ScheduleInfoDTO {

        private Long scheduleId;
        private Long userDeviceId;
        private RepeatType repeatType;
        private String day;
        private String time;
        private CleanMode mode;
    }

}
