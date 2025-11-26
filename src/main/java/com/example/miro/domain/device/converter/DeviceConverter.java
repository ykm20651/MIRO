package com.example.miro.domain.device.converter;

import com.example.miro.domain.device.dto.req.DeviceReqDTO;
import com.example.miro.domain.device.dto.res.DeviceResDTO;
import com.example.miro.domain.device.entity.Device;
import com.example.miro.domain.userDevice.entity.UserDevice;


public class DeviceConverter {

    public static Device toDevice(DeviceReqDTO.DeviceRegisterDTO dto){
        return Device.builder()
                .serialNumber(dto.getSerialNumber())
                .modelName(dto.getModelName())
                .firmwareVersion(dto.getFirmwareVersion())
                .build();
    }

    // Device + UserDevice -> 응답 DTO 변환
    public static DeviceResDTO.DeviceInfoDTO toDeviceInfoDTO(
            Device device,
            UserDevice userDevice
    ){
        return DeviceResDTO.DeviceInfoDTO.builder()
                .deviceId(device.getId())
                .serialNumber(device.getSerialNumber())
                .modelName(device.getModelName())
                .firmwareVersion(device.getFirmwareVersion())
                .defaultMode(userDevice.getDefaultMode())
                .autoCleanEnabled(userDevice.isAutoCleanEnabled())
                .isInitialized(userDevice.isInitialized())
                .build();
    }
}
