package com.example.miro.domain.schedule.repository;

import com.example.miro.domain.schedule.dto.res.ScheduleResDTO;
import com.example.miro.domain.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    // 04-02: 하나의 기기에 대한 스케줄 목록 DTO로 바로 조회
    @Query("""
        select new com.example.miro.domain.schedule.dto.res.ScheduleResDTO$ScheduleInfoDTO(
            s.id,
            ud.id,
            s.repeatType,
            s.day,
            s.time,
            s.mode,
            s.memo
        )
        from Schedule s
        join s.userDevice ud
        where ud.id = :userDeviceId
          and ud.user.id = :userId
        """)
    List<ScheduleResDTO.ScheduleInfoDTO> findScheduleInfosByUserDeviceAndUser(
            Long userDeviceId,
            Long userId
    );

    // 04-03: 단건 상세도 DTO로 바로
    @Query("""
        select new com.example.miro.domain.schedule.dto.res.ScheduleResDTO$ScheduleInfoDTO(
            s.id,
            ud.id,
            s.repeatType,
            s.day,
            s.time,
            s.mode,
            s.memo
        )
        from Schedule s
        join s.userDevice ud
        where s.id = :scheduleId
          and ud.user.id = :userId
        """)
    Optional<ScheduleResDTO.ScheduleInfoDTO> findScheduleInfoByIdAndUser(
            Long scheduleId,
            Long userId
    );

    // 04-04, 04-05: 수정/삭제를 위한 실제 엔티티 조회
    @Query("""
        select s
        from Schedule s
        join s.userDevice ud
        where s.id = :scheduleId
          and ud.user.id = :userId
    """)
    Optional<Schedule> findScheduleEntity(Long scheduleId, Long userId);

}
