package com.example.miro.domain.schedule.service.command;

import com.example.miro.domain.schedule.code.ScheduleErrorCode;
import com.example.miro.domain.schedule.converter.ScheduleConverter;
import com.example.miro.domain.schedule.dto.req.ScheduleReqDTO;
import com.example.miro.domain.schedule.dto.res.ScheduleResDTO;
import com.example.miro.domain.schedule.entity.Schedule;
import com.example.miro.domain.schedule.exception.ScheduleException;
import com.example.miro.domain.schedule.repository.ScheduleRepository;
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
public class ScheduleCommandServiceImpl implements ScheduleCommandService {

    private final ScheduleRepository scheduleRepository;
    private final UserDeviceRepository userDeviceRepository;

    /* 04-01 스케줄 생성 */
    @Override
    public ScheduleResDTO.ScheduleInfoDTO createSchedule(Long userId, ScheduleReqDTO.CreateScheduleDTO request) {

        UserDevice userDevice = userDeviceRepository
                .findByIdAndUserId(request.getUserDeviceId(), userId)
                .orElseThrow(() -> new UserDeviceException(UserDeviceErrorCode.USER_DEVICE_NOT_FOUND));

        Schedule schedule = ScheduleConverter.toSchedule(userDevice, request);

        scheduleRepository.save(schedule);

        return ScheduleConverter.toScheduleInfoDTO(schedule);
    }

    /* 04-04 스케줄 수정 */
    @Override
    public void updateSchedule(Long userId, Long scheduleId, ScheduleReqDTO.UpdateScheduleDTO request) {

        Schedule schedule = scheduleRepository
                .findScheduleEntity(scheduleId, userId)
                .orElseThrow(() -> new ScheduleException(ScheduleErrorCode.SCHEDULE_NOT_FOUND));

        // 엔티티 내부 update 메서드
        schedule.updateSchedule(
                request.getRepeatType(),
                request.getDay(),
                request.getTime(),
                request.getMode()
        );
    }

    /* 04-05 스케줄 삭제 */
    @Override
    public void deleteSchedule(Long userId, Long scheduleId) {

        Schedule schedule = scheduleRepository
                .findScheduleEntity(scheduleId, userId)
                .orElseThrow(() -> new ScheduleException(ScheduleErrorCode.SCHEDULE_NOT_FOUND));

        scheduleRepository.delete(schedule);
    }

}
