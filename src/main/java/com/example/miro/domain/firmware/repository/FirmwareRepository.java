package com.example.miro.domain.firmware.repository;

import com.example.miro.domain.firmware.entity.Firmware;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FirmwareRepository extends JpaRepository<Firmware, Long> {

    // 모델명으로 최신 버전(가장 최근 생성된) 찾기
    Optional<Firmware> findTopByModelNameOrderByCreatedAtDesc(String modelName);

    // or 단일 row라면
    Optional<Firmware> findByModelName(String modelName);

    // 전체 버전 리스트 (Entity로만 반환)
    List<Firmware> findAllByOrderByCreatedAtDesc();
}
