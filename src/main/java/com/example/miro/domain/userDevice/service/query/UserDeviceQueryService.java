package com.example.miro.domain.userDevice.service.query;

import com.example.miro.domain.userDevice.dto.res.UserDeviceResDTO;

import java.util.List;

public interface UserDeviceQueryService {
    List<UserDeviceResDTO.UserDeviceInfoDTO> getMyDevices(Long userId);

    UserDeviceResDTO.UserDeviceInfoDTO getMyDevice(Long userId, Long userDeviceId);
}
