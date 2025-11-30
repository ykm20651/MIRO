package com.example.miro.domain.inquiry.service.query;

import com.example.miro.domain.inquiry.code.InquiryErrorCode;
import com.example.miro.domain.inquiry.dto.res.InquiryResDTO;
import com.example.miro.domain.inquiry.exception.InquiryException;
import com.example.miro.domain.inquiry.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InquiryQueryServiceImpl implements InquiryQueryService {

    private final InquiryRepository inquiryRepository;

    /* 06-02 목록 조회 */
    @Override
    public List<InquiryResDTO.InquiryInfoDTO> getMyInquiries(Long userId) {
        return inquiryRepository.findMyInquiries(userId);
    }

    /* 06-03 상세 조회 */
    @Override
    public InquiryResDTO.InquiryInfoDTO getInquiry(Long userId, Long inquiryId) {

        return inquiryRepository.findInquiryInfo(inquiryId, userId)
                .orElseThrow(() -> new InquiryException(InquiryErrorCode.INQUIRY_NOT_FOUND));
    }
}
