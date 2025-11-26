package com.example.miro.domain.device.service.command;

import com.example.miro.domain.device.dto.req.DeviceReqDTO;
import com.example.miro.domain.device.dto.res.DeviceResDTO;

public interface DeviceCommandService {
    DeviceResDTO.DeviceInfoDTO registerDevice(
            Long userId,
            DeviceReqDTO.DeviceRegisterDTO dto
    );
}
