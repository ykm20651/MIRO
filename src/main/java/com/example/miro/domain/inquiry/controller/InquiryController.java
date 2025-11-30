package com.example.miro.domain.inquiry.controller;

import com.example.miro.domain.inquiry.code.InquirySuccessCode;
import com.example.miro.domain.inquiry.dto.req.InquiryReqDTO;
import com.example.miro.domain.inquiry.dto.res.InquiryResDTO;
import com.example.miro.domain.inquiry.service.command.InquiryCommandService;
import com.example.miro.domain.inquiry.service.query.InquiryQueryService;
import com.example.miro.global.apiPayLoad.ApiResponse;
import com.example.miro.global.security.CustomPrincipal;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inquiry")
public class InquiryController implements InquiryControllerDocs {

    private final InquiryCommandService inquiryCommandService;
    private final InquiryQueryService inquiryQueryService;

    /* 06-01 문의 작성 */
    @Override
    public ApiResponse<InquiryResDTO.InquiryInfoDTO> createInquiry(
            @AuthenticationPrincipal CustomPrincipal principal,
            @Valid @RequestBody InquiryReqDTO.CreateInquiryDTO request
    ) {
        return ApiResponse.onSuccess(
                InquirySuccessCode.INQUIRY_CREATED,
                inquiryCommandService.createInquiry(principal.getUserId(), request)
        );
    }

    /* 06-02 내 문의 목록 조회 */
    @Override
    public ApiResponse<List<InquiryResDTO.InquiryInfoDTO>> getMyInquiries(
            @AuthenticationPrincipal CustomPrincipal principal
    ) {
        return ApiResponse.onSuccess(
                InquirySuccessCode.INQUIRY_LIST_FETCHED,
                inquiryQueryService.getMyInquiries(principal.getUserId())
        );
    }

    /* 06-03 문의 상세 조회 */
    @Override
    public ApiResponse<InquiryResDTO.InquiryInfoDTO> getInquiry(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long inquiryId
    ) {
        return ApiResponse.onSuccess(
                InquirySuccessCode.INQUIRY_DETAIL_FETCHED,
                inquiryQueryService.getInquiry(principal.getUserId(), inquiryId)
        );
    }

    /* 06-04 문의 수정 */
    @Override
    public ApiResponse<Void> updateInquiry(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long inquiryId,
            @Valid @RequestBody InquiryReqDTO.UpdateInquiryDTO request
    ) {
        inquiryCommandService.updateInquiry(principal.getUserId(), inquiryId, request);
        return ApiResponse.onSuccess(InquirySuccessCode.INQUIRY_DETAIL_FETCHED);
    }

    /* 06-05 문의 삭제 */
    @Override
    public ApiResponse<Void> deleteInquiry(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long inquiryId
    ) {
        inquiryCommandService.deleteInquiry(principal.getUserId(), inquiryId);
        return ApiResponse.onSuccess(InquirySuccessCode.INQUIRY_DELETED);
    }
}
