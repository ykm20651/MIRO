package com.example.miro.domain.inquiry.service.command;

import com.example.miro.domain.inquiry.code.InquiryErrorCode;
import com.example.miro.domain.inquiry.converter.InquiryConverter;
import com.example.miro.domain.inquiry.dto.req.InquiryReqDTO;
import com.example.miro.domain.inquiry.dto.res.InquiryResDTO;
import com.example.miro.domain.inquiry.entity.Inquiry;
import com.example.miro.domain.inquiry.exception.InquiryException;
import com.example.miro.domain.inquiry.repository.InquiryRepository;
import com.example.miro.domain.user.code.UserErrorCode;
import com.example.miro.domain.user.entity.User;
import com.example.miro.domain.user.exception.UserException;
import com.example.miro.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class InquiryCommandServiceImpl implements InquiryCommandService {

    private final InquiryRepository inquiryRepository;
    private final UserRepository userRepository;

    /* 06-01 문의 작성 */
    @Override
    public InquiryResDTO.InquiryInfoDTO createInquiry(Long userId, InquiryReqDTO.CreateInquiryDTO request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException(UserErrorCode.USER_ID_NOT_FOUND));

        Inquiry inquiry = InquiryConverter.toInquiry(user, request);

        inquiryRepository.save(inquiry);

        return InquiryConverter.toInquiryInfoDTO(inquiry);
    }

    /* 06-04 문의 수정 */
    @Override
    public void updateInquiry(Long userId, Long inquiryId, InquiryReqDTO.UpdateInquiryDTO request) {

        Inquiry inquiry = inquiryRepository.findInquiryEntity(inquiryId, userId)
                .orElseThrow(() -> new InquiryException(InquiryErrorCode.INQUIRY_NOT_FOUND));

        inquiry.updateInquiry(request.getTitle(), request.getMessage());
    }

    /* 06-05 문의 삭제 */
    @Override
    public void deleteInquiry(Long userId, Long inquiryId) {

        Inquiry inquiry = inquiryRepository.findInquiryEntity(inquiryId, userId)
                .orElseThrow(() -> new InquiryException(InquiryErrorCode.INQUIRY_NOT_FOUND));

        inquiryRepository.delete(inquiry);
    }
}

