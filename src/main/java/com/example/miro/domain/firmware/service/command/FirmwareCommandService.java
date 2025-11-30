package com.example.miro.domain.firmware.service.command;

import com.example.miro.domain.firmware.dto.req.FirmwareReqDTO;
import com.example.miro.domain.firmware.dto.res.FirmwareResDTO;

public interface FirmwareCommandService {

    /* 07-02 펌웨어 업데이트 */
    void updateFirmware(Long userId, FirmwareReqDTO.UpdateRequestDTO request);

    /* 07-03 새 펌웨어 등록 */
    FirmwareResDTO.FirmwareInfoDTO createFirmware(FirmwareReqDTO.RegisterFirmwareDTO request);

    /* 07-05 펌웨어 삭제 */
    void deleteFirmware(Long firmwareId);
}
