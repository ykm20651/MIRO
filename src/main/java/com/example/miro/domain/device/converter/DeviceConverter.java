package com.example.miro.domain.device.converter;

import com.example.miro.domain.device.dto.req.DeviceReqDTO;
import com.example.miro.domain.device.dto.res.DeviceResDTO;
import com.example.miro.domain.device.entity.Device;

public class DeviceConverter {

    /* 02-01 기기 등록 : DTO -> Entity */
    public static Device toDevice(DeviceReqDTO.CreateDeviceDTO dto) {
        return Device.builder()
                .serialNumber(dto.getSerialNumber())
                .modelName(dto.getModelName())
                .firmwareVersion(dto.getFirmwareVersion())
                .build();
    }

    /* 02-02/03 응답 DTO 변환 */
    public static DeviceResDTO.DeviceInfoDTO toDeviceInfoDTO(Device device) {
        return DeviceResDTO.DeviceInfoDTO.builder()
                .id(device.getId())
                .serialNumber(device.getSerialNumber())
                .modelName(String.valueOf(device.getModelName()))
                .firmwareVersion(device.getFirmwareVersion())
                .build();
    }
}
