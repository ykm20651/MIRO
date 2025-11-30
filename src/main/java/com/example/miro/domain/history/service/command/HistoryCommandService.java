package com.example.miro.domain.history.service.command;

import com.example.miro.domain.history.dto.req.HistoryReqDTO;
import com.example.miro.domain.history.dto.res.HistoryResDTO;

public interface HistoryCommandService {
    /* 05-01 청소 기록 업로드 */
    HistoryResDTO.HistoryInfoDTO createHistory(Long userId, HistoryReqDTO.CreateHistoryDTO request);
}
