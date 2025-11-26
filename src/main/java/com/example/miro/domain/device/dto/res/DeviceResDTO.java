package com.example.miro.domain.device.dto.res;

import lombok.Builder;
import lombok.Getter;

public class DeviceResDTO {

    /* 기기 상세/등록 응답 DTO */
    @Getter
    @Builder
    public static class DeviceInfoDTO {
        private final Long id;
        private final String serialNumber;
        private final String modelName;
        private final String firmwareVersion;
    }
}
