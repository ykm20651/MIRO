package com.example.miro.domain.device.dto.req;

import lombok.Builder;
import lombok.Getter;

public class DeviceReqDTO {

    @Getter
    @Builder
    public static class DeviceRegisterDTO{
        private String serialNumber;
        private String modelName;
        private String firmwareVersion;
    }
}
