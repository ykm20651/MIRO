package com.example.miro.domain.inquiry.service.query;

import com.example.miro.domain.inquiry.dto.res.InquiryResDTO;

import java.util.List;

public interface InquiryQueryService {
    /* 06-02 목록 조회 */
    List<InquiryResDTO.InquiryInfoDTO> getMyInquiries(Long userId);

    /* 06-03 상세 조회 */
    InquiryResDTO.InquiryInfoDTO getInquiry(Long userId, Long inquiryId);
}
