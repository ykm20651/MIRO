package com.example.miro.domain.schedule.service.query;

import com.example.miro.domain.schedule.code.ScheduleErrorCode;
import com.example.miro.domain.schedule.dto.res.ScheduleResDTO;
import com.example.miro.domain.schedule.exception.ScheduleException;
import com.example.miro.domain.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleQueryServiceImpl implements ScheduleQueryService {

    private final ScheduleRepository scheduleRepository;

    /* 04-02 특정 유저의 특정 기기에 대한 스케줄 전체 조회 */
    @Override
    public List<ScheduleResDTO.ScheduleInfoDTO> getSchedulesByUserDevice(Long userId, Long userDeviceId) {

        return scheduleRepository.findScheduleInfosByUserDeviceAndUser(userDeviceId, userId);
    }

    /* 04-03 스케줄 상세 조회 */
    @Override
    public ScheduleResDTO.ScheduleInfoDTO getSchedule(Long userId, Long scheduleId) {

        return scheduleRepository.findScheduleInfoByIdAndUser(scheduleId, userId)
                .orElseThrow(() -> new ScheduleException(ScheduleErrorCode.SCHEDULE_NOT_FOUND));
    }

}
