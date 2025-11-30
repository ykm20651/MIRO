package com.example.miro.domain.history.service.command;

import com.example.miro.domain.history.converter.HistoryConverter;
import com.example.miro.domain.history.dto.req.HistoryReqDTO;
import com.example.miro.domain.history.dto.res.HistoryResDTO;
import com.example.miro.domain.history.entity.History;
import com.example.miro.domain.history.repository.HistoryRepository;
import com.example.miro.domain.userDevice.code.UserDeviceErrorCode;
import com.example.miro.domain.userDevice.entity.UserDevice;
import com.example.miro.domain.userDevice.exception.UserDeviceException;
import com.example.miro.domain.userDevice.repository.UserDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class HistoryCommandServiceImpl implements HistoryCommandService {

    private final HistoryRepository historyRepository;
    private final UserDeviceRepository userDeviceRepository;

    /* 05-01 청소 기록 업로드 */
    @Override
    public HistoryResDTO.HistoryInfoDTO createHistory(Long userId, HistoryReqDTO.CreateHistoryDTO request) {

        UserDevice userDevice = userDeviceRepository
                .findByIdAndUserId(request.getUserDeviceId(), userId)
                .orElseThrow(() -> new UserDeviceException(UserDeviceErrorCode.USER_DEVICE_NOT_FOUND));

        History history = HistoryConverter.toHistory(userDevice, request);

        historyRepository.save(history);

        return HistoryConverter.toHistoryInfoDTO(history);
    }
}
