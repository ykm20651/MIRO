package com.example.miro.domain.history.service.query;

import com.example.miro.domain.history.code.HistoryErrorCode;
import com.example.miro.domain.history.dto.res.HistoryResDTO;
import com.example.miro.domain.history.exception.HistoryException;
import com.example.miro.domain.history.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HistoryQueryServiceImpl implements HistoryQueryService {

    private final HistoryRepository historyRepository;

    /* 05-02 기록 목록 조회 */
    @Override
    public List<HistoryResDTO.HistoryInfoDTO> getHistoryList(Long userId, Long userDeviceId) {

        return historyRepository.findHistoryInfosByUserDeviceAndUser(userDeviceId, userId);
    }

    /* 05-03 단일 기록 조회 */
    @Override
    public HistoryResDTO.HistoryInfoDTO getHistory(Long userId, Long historyId) {

        return historyRepository.findHistoryInfoByIdAndUser(historyId, userId)
                .orElseThrow(() -> new HistoryException(HistoryErrorCode.HISTORY_NOT_FOUND));
    }
}
