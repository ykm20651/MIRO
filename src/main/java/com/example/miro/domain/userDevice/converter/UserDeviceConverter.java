package com.example.miro.domain.userDevice.converter;

import com.example.miro.domain.device.entity.Device;
import com.example.miro.domain.user.entity.User;
import com.example.miro.domain.userDevice.dto.req.UserDeviceReqDTO;
import com.example.miro.domain.userDevice.dto.res.UserDeviceResDTO;
import com.example.miro.domain.userDevice.entity.UserDevice;

public class UserDeviceConverter {

    public static UserDevice toUserDevice(User user, Device device, UserDeviceReqDTO.CreateUserDeviceDTO request) {
        return UserDevice.builder()
                .user(user)
                .device(device)
                .defaultMode(request.getDefaultMode())
                .autoCleanEnabled(true)
                .isInitialized(true)
                .build();
    }

    public static UserDeviceResDTO.UserDeviceInfoDTO toUserDeviceInfoDTO(UserDevice userDevice) {
        return UserDeviceResDTO.UserDeviceInfoDTO.builder()
                .userDeviceId(userDevice.getId())
                .deviceId(userDevice.getDevice().getId())
                .serialNumber(userDevice.getDevice().getSerialNumber())
                .modelName(userDevice.getDevice().getModelName())
                .firmwareVersion(userDevice.getDevice().getFirmwareVersion())
                .defaultMode(String.valueOf(userDevice.getDefaultMode()))
                .autoCleanEnabled(userDevice.isAutoCleanEnabled())
                .build();
    }
}
