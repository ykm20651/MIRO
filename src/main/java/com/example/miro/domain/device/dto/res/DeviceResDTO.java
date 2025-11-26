package com.example.miro.domain.device.dto.res;

import com.example.miro.domain.userDevice.enums.CleanMode;
import lombok.Builder;
import lombok.Getter;

public class DeviceResDTO {

    @Getter
    @Builder
    public static class DeviceInfoDTO{
        private Long deviceId;
        private String serialNumber;
        private String modelName;
        private String firmwareVersion;

        private CleanMode defaultMode;
        private boolean autoCleanEnabled;
        private boolean isInitialized;
    }
}
