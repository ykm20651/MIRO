package com.example.miro.domain.userDevice.dto.res;

import lombok.Builder;
import lombok.Getter;

public class UserDeviceResDTO {

    @Getter
    @Builder
    public static class UserDeviceInfoDTO {

        private Long userDeviceId;
        private Long deviceId;
        private String serialNumber;
        private String modelName;
        private String firmwareVersion;

        private String defaultMode;
        private boolean autoCleanEnabled;
        private boolean isInitialized;
    }

}
