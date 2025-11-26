package com.example.miro.domain.device.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

public class DeviceReqDTO {

    /* 02-01 기기 자체 등록 요청 DTO */
    @Getter
    @Builder
    public static class CreateDeviceDTO {

        @NotBlank(message = "serialNumber는 필수 값입니다.")
        private String serialNumber;

        @NotBlank(message = "modelName은 필수 값입니다.")
        private String modelName;

        @NotBlank(message = "firmwareVersion은 필수 값입니다.")
        private String firmwareVersion;
    }


    /* 02-04 기기 정보 수정 요청 DTO */
    @Getter
    @Builder
    public static class UpdateDeviceDTO {

        @NotBlank(message = "modelName은 필수 값입니다.")
        private String modelName;

        @NotBlank(message = "firmwareVersion은 필수 값입니다.")
        private String firmwareVersion;
    }

}
