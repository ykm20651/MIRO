package com.example.miro.domain.schedule.dto.req;

import com.example.miro.domain.schedule.enums.RepeatType;
import com.example.miro.domain.userDevice.enums.CleanMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

public class ScheduleReqDTO {

    /* 04-01 스케줄 생성 */
    @Getter
    @Builder
    public static class CreateScheduleDTO {

        @NotNull(message = "userDeviceId는 필수 값입니다.")
        private Long userDeviceId;

        @NotNull(message = "repeatType은 필수 값입니다.")
        private RepeatType repeatType;

        @NotBlank(message = "day는 필수 값입니다.")
        private String day;

        @NotBlank(message = "time은 필수 값입니다.")
        private String time;

        @NotNull(message = "mode는 필수 값입니다.")
        private CleanMode mode;
    }

    /* 04-04 스케줄 수정 */
    @Getter
    @Builder
    public static class UpdateScheduleDTO {

        @NotNull(message = "repeatType은 필수 값입니다.")
        private RepeatType repeatType;

        @NotBlank(message = "day는 필수 값입니다.")
        private String day;

        @NotBlank(message = "time은 필수 값입니다.")
        private String time;

        @NotNull(message = "mode는 필수 값입니다.")
        private CleanMode mode;
    }
}
