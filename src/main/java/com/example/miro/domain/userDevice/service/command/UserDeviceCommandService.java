package com.example.miro.domain.userDevice.service.command;

import com.example.miro.domain.userDevice.dto.req.UserDeviceReqDTO;
import com.example.miro.domain.userDevice.dto.res.UserDeviceResDTO;

public interface UserDeviceCommandService {
    UserDeviceResDTO.UserDeviceInfoDTO createUserDevice(Long userId, UserDeviceReqDTO.CreateUserDeviceDTO request);

    void updateUserDevice(Long userId, Long userDeviceId, UserDeviceReqDTO.UpdateUserDeviceDTO request);

    void deleteUserDevice(Long userId, Long userDeviceId);
}
