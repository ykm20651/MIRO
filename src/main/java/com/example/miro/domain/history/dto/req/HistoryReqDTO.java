package com.example.miro.domain.history.dto.req;

import com.example.miro.domain.history.enums.HistoryStatus;
import com.example.miro.domain.userDevice.enums.CleanMode;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.time.LocalDateTime;

public class HistoryReqDTO {

    @Getter
    @Builder
    @NoArgsConstructor //Jackson이 JSON -> 객체 역직렬화 할 때 필요함
    @AllArgsConstructor //DTO Projection 때문.
    public static class CreateHistoryDTO {

        @NotNull(message = "userDeviceId는 필수입니다.")
        private Long userDeviceId;

        @NotNull(message = "mode는 필수입니다.")
        private CleanMode mode;

        @NotNull(message = "startedAt은 필수입니다.")
        private LocalDateTime startedAt;

        @NotNull(message = "endedAt은 필수입니다.")
        private LocalDateTime endedAt;

        @NotNull(message = "status는 필수입니다.")
        private HistoryStatus status;

        @PositiveOrZero(message = "duration은 0 이상이어야 합니다.")
        private int duration;

        @PositiveOrZero(message = "batteryUsage는 0 이상이어야 합니다.")
        private int batteryUsage;

        @PositiveOrZero(message = "areaSize는 0 이상이어야 합니다.")
        private int areaSize;
    }
}
