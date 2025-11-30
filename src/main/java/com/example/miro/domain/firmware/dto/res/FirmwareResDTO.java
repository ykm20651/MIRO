package com.example.miro.domain.firmware.dto.res;

import lombok.*;
import java.time.LocalDateTime;

public class FirmwareResDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LatestFirmwareDTO {
        private Long firmwareId;
        private String modelName;
        private String latestVersion;
        private String downloadUrl;
        private LocalDateTime createdAt;
    }


    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FirmwareInfoDTO {
        private Long firmwareId;
        private String modelName;
        private String latestVersion;
        private String downloadUrl;
        private LocalDateTime createdAt;
    }
}
