package com.example.miro.domain.inquiry.dto.res;

import com.example.miro.domain.inquiry.enums.InquiryStatus;
import com.example.miro.domain.inquiry.enums.InquiryType;
import lombok.*;

import java.time.LocalDateTime;

public class InquiryResDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InquiryInfoDTO {

        private Long inquiryId;
        private InquiryType type;
        private String title;
        private String message;
        private InquiryStatus status;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }
}
