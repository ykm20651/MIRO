package com.example.miro.domain.inquiry.converter;

import com.example.miro.domain.inquiry.dto.req.InquiryReqDTO;
import com.example.miro.domain.inquiry.dto.res.InquiryResDTO;
import com.example.miro.domain.inquiry.entity.Inquiry;
import com.example.miro.domain.inquiry.enums.InquiryStatus;
import com.example.miro.domain.user.entity.User;

public class InquiryConverter {

    public static Inquiry toInquiry(User user, InquiryReqDTO.CreateInquiryDTO req) {
        return Inquiry.builder()
                .user(user)
                .type(req.getType())
                .title(req.getTitle())
                .message(req.getMessage())
                .status(InquiryStatus.SUBMIT)
                .build();
    }

    public static InquiryResDTO.InquiryInfoDTO toInquiryInfoDTO(Inquiry inquiry) {
        return InquiryResDTO.InquiryInfoDTO.builder()
                .inquiryId(inquiry.getId())
                .type(inquiry.getType())
                .title(inquiry.getTitle())
                .message(inquiry.getMessage())
                .status(inquiry.getStatus())
                .createdAt(inquiry.getCreatedAt())
                .updatedAt(inquiry.getUpdatedAt())
                .build();
    }
}
