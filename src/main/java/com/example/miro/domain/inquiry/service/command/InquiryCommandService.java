package com.example.miro.domain.inquiry.service.command;

import com.example.miro.domain.inquiry.dto.req.InquiryReqDTO;
import com.example.miro.domain.inquiry.dto.res.InquiryResDTO;

public interface InquiryCommandService {
    /* 06-01 문의 작성 */
    InquiryResDTO.InquiryInfoDTO createInquiry(Long userId, InquiryReqDTO.CreateInquiryDTO request);

    /* 06-04 문의 수정 */
    void updateInquiry(Long userId, Long inquiryId, InquiryReqDTO.UpdateInquiryDTO request);

    /* 06-05 문의 삭제 */
    void deleteInquiry(Long userId, Long inquiryId);
}
