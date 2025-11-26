package com.example.miro.domain.userDevice.dto.req;

import com.example.miro.domain.userDevice.enums.CleanMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

public class UserDeviceReqDTO {

    /* 03-01 사용자 기기 등록 */
    @Getter
    @Builder
    public static class CreateUserDeviceDTO {

        @NotNull(message = "등록할 deviceId는 필수 값입니다.")
        private Long deviceId;

        @NotNull(message = "defaultMode는 필수 값입니다.")
        private CleanMode defaultMode;
    }

    /* 03-04 사용자 기기 설정 수정 */
    @Getter
    @Builder
    public static class UpdateUserDeviceDTO {

        @NotNull(message = "defaultMode는 필수 값입니다.")
        private CleanMode defaultMode;

        @NotNull(message = "autoCleanEnabled 값은 필수입니다.")
        private Boolean autoCleanEnabled;
    }
}
