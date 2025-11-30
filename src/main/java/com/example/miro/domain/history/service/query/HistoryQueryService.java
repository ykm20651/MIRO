package com.example.miro.domain.history.service.query;

import com.example.miro.domain.history.dto.res.HistoryResDTO;

import java.util.List;

public interface HistoryQueryService {
    /* 05-02 기록 목록 조회 */
    List<HistoryResDTO.HistoryInfoDTO> getHistoryList(Long userId, Long userDeviceId);

    /* 05-03 단일 기록 조회 */
    HistoryResDTO.HistoryInfoDTO getHistory(Long userId, Long historyId);
}
