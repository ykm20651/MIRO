package com.example.miro.domain.device.repository;

import com.example.miro.domain.device.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Long> {
    boolean  existsBySerialNumber(String SerialNumber);
    Optional<Device> findByModelName(String modelName);
    Optional<Device> findBySerialNumber(String serialNumber);


}
