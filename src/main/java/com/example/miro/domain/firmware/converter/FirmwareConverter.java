package com.example.miro.domain.firmware.converter;

import com.example.miro.domain.firmware.dto.req.FirmwareReqDTO;
import com.example.miro.domain.firmware.dto.res.FirmwareResDTO;
import com.example.miro.domain.firmware.entity.Firmware;

public class FirmwareConverter {

    public static Firmware toFirmware(FirmwareReqDTO.RegisterFirmwareDTO dto) {
        return Firmware.builder()
                .modelName(dto.getModelName())
                .latestVersion(dto.getLatestVersion())
                .downloadUrl(dto.getDownloadUrl())
                .build();
    }

    public static FirmwareResDTO.FirmwareInfoDTO toFirmwareInfoDTO(Firmware firmware) {
        return FirmwareResDTO.FirmwareInfoDTO.builder()
                .firmwareId(firmware.getId())
                .modelName(String.valueOf(firmware.getModelName()))
                .latestVersion(firmware.getLatestVersion())
                .downloadUrl(firmware.getDownloadUrl())
                .build();
    }

    public static FirmwareResDTO.LatestFirmwareDTO toLatestFirmwareDTO(Firmware firmware) {
        return FirmwareResDTO.LatestFirmwareDTO.builder()
                .modelName(String.valueOf(firmware.getModelName()))
                .latestVersion(firmware.getLatestVersion())
                .downloadUrl(firmware.getDownloadUrl())
                .build();
    }
}
