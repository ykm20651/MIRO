package com.example.miro.domain.firmware.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class FirmwareReqDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegisterFirmwareDTO {

        @NotBlank(message = "모델명은 필수입니다.")
        private String modelName;

        @NotBlank(message = "버전 정보는 필수입니다.")
        private String latestVersion;

        @NotBlank(message = "다운로드 URL은 필수입니다.")
        private String downloadUrl;
    }


    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateRequestDTO {

        @NotBlank(message = "구매한 기기의 시리얼 넘버값은 필수입니다.")
        private String serialNumber;   // 어떤 '기기'를 업데이트할지 선택
    }
}
