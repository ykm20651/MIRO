package com.example.miro.domain.device.service.query;

import com.example.miro.domain.device.dto.res.DeviceResDTO;

import java.util.List;

public interface DeviceQueryService {

    /* 02-02 상세 조회 */
    DeviceResDTO.DeviceInfoDTO getDevice(Long userId, Long deviceId);

    /* 02-03 목록 조회 */
    List<DeviceResDTO.DeviceInfoDTO> getAllDevices(Long userId);
}

