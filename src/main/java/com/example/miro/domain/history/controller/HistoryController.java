package com.example.miro.domain.history.controller;

import com.example.miro.domain.history.code.HistorySuccessCode;
import com.example.miro.domain.history.dto.req.HistoryReqDTO;
import com.example.miro.domain.history.dto.res.HistoryResDTO;
import com.example.miro.domain.history.service.command.HistoryCommandService;
import com.example.miro.domain.history.service.query.HistoryQueryService;
import com.example.miro.global.apiPayLoad.ApiResponse;
import com.example.miro.global.security.CustomPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/history")
public class HistoryController implements HistoryControllerDocs {

    private final HistoryCommandService historyCommandService;
    private final HistoryQueryService historyQueryService;

    /* 05-01 기록 업로드 */
    @Override
    public ApiResponse<HistoryResDTO.HistoryInfoDTO> createHistory(
            @AuthenticationPrincipal CustomPrincipal principal,
            @Valid @RequestBody HistoryReqDTO.CreateHistoryDTO request
    ) {
        return ApiResponse.onSuccess(
                HistorySuccessCode.HISTORY_CREATED,
                historyCommandService.createHistory(principal.getUserId(), request)
        );
    }

    /* 05-02 기록 목록 조회 */
    @Override
    public ApiResponse<List<HistoryResDTO.HistoryInfoDTO>> getHistoryList(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long userDeviceId
    ) {
        return ApiResponse.onSuccess(
                HistorySuccessCode.HISTORY_LIST_FETCHED,
                historyQueryService.getHistoryList(principal.getUserId(), userDeviceId)
        );
    }

    /* 05-03 기록 상세 조회 */
    @Override
    public ApiResponse<HistoryResDTO.HistoryInfoDTO> getHistory(
            @AuthenticationPrincipal CustomPrincipal principal,
            @PathVariable Long historyId
    ) {
        return ApiResponse.onSuccess(
                HistorySuccessCode.HISTORY_DETAIL_FETCHED,
                historyQueryService.getHistory(principal.getUserId(), historyId)
        );
    }
}
