package com.example.miro.domain.firmware.service.query;

import com.example.miro.domain.firmware.dto.res.FirmwareResDTO;

import java.util.List;

public interface FirmwareQueryService {

    /* 07-01 최신 버전 조회 */
    FirmwareResDTO.LatestFirmwareDTO getLatestFirmware(String modelName);

    /* 07-04 전체 버전 리스트 조회 */
    List<FirmwareResDTO.FirmwareInfoDTO> getFirmwareList();
}
