package com.example.miro.domain.history.repository;

import com.example.miro.domain.history.dto.res.HistoryResDTO;
import com.example.miro.domain.history.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HistoryRepository extends JpaRepository<History,Long> {

    /* 05-02: 기록 목록 조회 (DTO Projection) */
    @Query("""
        select new com.example.miro.domain.history.dto.res.HistoryResDTO$HistoryInfoDTO(
            h.id,
            ud.id,
            h.mode,
            h.startedAt,
            h.endedAt,
            h.status,
            h.duration,
            h.batteryUsage,
            h.areaSize
        )
        from History h
        join h.userDevice ud
        where ud.id = :userDeviceId
          and ud.user.id = :userId
        order by h.startedAt desc
    """)
    List<HistoryResDTO.HistoryInfoDTO> findHistoryInfosByUserDeviceAndUser(
            Long userDeviceId,
            Long userId
    );

    /* 05-03: 단일 기록 조회 */
    @Query("""
        select new com.example.miro.domain.history.dto.res.HistoryResDTO$HistoryInfoDTO(
            h.id,
            ud.id,
            h.mode,
            h.startedAt,
            h.endedAt,
            h.status,
            h.duration,
            h.batteryUsage,
            h.areaSize
        )
        from History h
        join h.userDevice ud
        where h.id = :historyId
          and ud.user.id = :userId
    """)
    Optional<HistoryResDTO.HistoryInfoDTO> findHistoryInfoByIdAndUser(
            Long historyId,
            Long userId
    );

    /* 엔티티 조회 */
    @Query("""
        select h
        from History h
        join h.userDevice ud
        where h.id = :historyId
          and ud.user.id = :userId
    """)
    Optional<History> findHistoryEntity(Long historyId, Long userId);
}
