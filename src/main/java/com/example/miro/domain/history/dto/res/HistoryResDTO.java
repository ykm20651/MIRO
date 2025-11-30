package com.example.miro.domain.history.dto.res;

import com.example.miro.domain.history.enums.HistoryStatus;
import com.example.miro.domain.userDevice.enums.CleanMode;
import lombok.*;

import java.time.LocalDateTime;

public class HistoryResDTO {

    @Getter
    @Builder
    @NoArgsConstructor // <- Reflection/Jackson 대비
    @AllArgsConstructor // <- DTO Projection 필수
    public static class HistoryInfoDTO {

        private Long historyId;
        private Long userDeviceId;

        private CleanMode mode;
        private LocalDateTime startedAt;
        private LocalDateTime endedAt;
        private HistoryStatus status;

        private int duration;
        private int batteryUsage;
        private int areaSize;
    }
}
