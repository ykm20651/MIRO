package com.example.miro.domain.device.service.command;

import com.example.miro.domain.device.dto.req.DeviceReqDTO;
import com.example.miro.domain.device.dto.res.DeviceResDTO;

public interface DeviceCommandService {


    /* 02-01 기기 등록 */
    DeviceResDTO.DeviceInfoDTO createDevice(Long adminId, DeviceReqDTO.CreateDeviceDTO request);

    /* 02-04 기기 수정 */
    void updateDevice(Long adminId, Long deviceId, DeviceReqDTO.UpdateDeviceDTO request);

    /* 02-05 기기 삭제 */
    void deleteDevice(Long adminId, Long deviceId);
}
