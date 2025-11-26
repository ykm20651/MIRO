package com.example.miro.domain.firmware.repository;

import com.example.miro.domain.firmware.entity.Firmware;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirmwareRepository extends JpaRepository<Firmware,Long> {
}
