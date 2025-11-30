package com.example.miro.domain.firmware.repository;

import com.example.miro.domain.firmware.entity.FirmwareUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirmwareUpdateRepository extends JpaRepository<FirmwareUpdate, Long> {
}
