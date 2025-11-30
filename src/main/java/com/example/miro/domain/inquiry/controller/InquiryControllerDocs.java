package com.example.miro.domain.inquiry.controller;

import com.example.miro.domain.inquiry.dto.req.InquiryReqDTO;
import com.example.miro.domain.inquiry.dto.res.InquiryResDTO;
import com.example.miro.global.apiPayLoad.ApiResponse;
import com.example.miro.global.security.CustomPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "06 Inquiry", description = "06번대 고객 문의(Inquiry) API")
public interface InquiryControllerDocs {

    /* 06-01 문의 작성 */
    @Operation(
            summary = "06-01 문의 작성",
            operationId = "06-01",
            description = "유저가 제목, 내용, 문의 타입을 입력하여 문의를 생성합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "문의 생성 성공 (INQ201_1)",
                    content = @Content(schema = @Schema(implementation = InquiryResDTO.InquiryInfoDTO.class))
            )
    })
    @PostMapping
    ApiResponse<InquiryResDTO.InquiryInfoDTO> createInquiry(
            @AuthenticationPrincipal CustomPrincipal principal,
            @Valid @RequestBody InquiryReqDTO.CreateInquiryDTO request
    );


    /* 06-02 내 문의 목록 조회 */
    @Operation(
            summary = "06-02 내 문의 목록 조회",
            operationId = "06-02",
            description = "내가 작성한 모든 문의 목록을 조회합니다."
    )
    @GetMapping("/me")
    ApiResponse<List<InquiryResDTO.InquiryInfoDTO>> getMyInquiries(
            @AuthenticationPrincipal CustomPrincipal principal
    );


    /* 06-03 문의 상세 조회 */
    @Operation(
            summary = "06-03 문의 상세 조회",
            operationId = "06-03",
            description = "특정 문의 ID를 기반으로 상세 내용을 조회합니다."
    )
    @GetMapping("/{inquiryId}")
    ApiResponse<InquiryResDTO.InquiryInfoDTO> getInquiry(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long inquiryId
    );


    /* 06-04 문의 수정 */
    @Operation(
            summary = "06-04 문의 수정",
            operationId = "06-04",
            description = "제목/내용을 수정합니다. 본인이 작성한 문의만 수정할 수 있습니다."
    )
    @PatchMapping("/{inquiryId}")
    ApiResponse<Void> updateInquiry(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long inquiryId,
            @Valid @RequestBody InquiryReqDTO.UpdateInquiryDTO request
    );


    /* 06-05 문의 삭제 */
    @Operation(
            summary = "06-05 문의 삭제",
            operationId = "06-05",
            description = "내가 작성한 문의를 삭제합니다."
    )
    @DeleteMapping("/{inquiryId}")
    ApiResponse<Void> deleteInquiry(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long inquiryId
    );
}
