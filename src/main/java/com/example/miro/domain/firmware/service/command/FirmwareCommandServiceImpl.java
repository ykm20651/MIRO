package com.example.miro.domain.firmware.service.command;

import com.example.miro.domain.device.code.DeviceErrorCode;
import com.example.miro.domain.device.entity.Device;
import com.example.miro.domain.device.exception.DeviceException;
import com.example.miro.domain.device.repository.DeviceRepository;
import com.example.miro.domain.firmware.code.FirmwareErrorCode;
import com.example.miro.domain.firmware.dto.req.FirmwareReqDTO;
import com.example.miro.domain.firmware.dto.res.FirmwareResDTO;
import com.example.miro.domain.firmware.entity.Firmware;
import com.example.miro.domain.firmware.entity.FirmwareUpdate;
import com.example.miro.domain.firmware.enums.FirmwareUpdateStatus;
import com.example.miro.domain.firmware.exception.FirmwareException;
import com.example.miro.domain.firmware.repository.FirmwareRepository;
import com.example.miro.domain.firmware.repository.FirmwareUpdateRepository;
import com.example.miro.domain.firmware.converter.FirmwareConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class FirmwareCommandServiceImpl implements FirmwareCommandService {

    private final FirmwareRepository firmwareRepository;
    private final FirmwareUpdateRepository firmwareUpdateRepository;
    private final DeviceRepository deviceRepository;

    /* 07-02 펌웨어 업데이트 */
    @Override
    public void updateFirmware(Long userId, FirmwareReqDTO.UpdateRequestDTO request) {

        // 1. 기기 찾기
        Device device = deviceRepository.findBySerialNumber(request.getSerialNumber())
                .orElseThrow(() -> new DeviceException(DeviceErrorCode.DEVICE_NOT_FOUND));

        // 2. 현재 기기 펌웨어 버전
        String currentVersion = device.getFirmwareVersion();

        // 3. 최신 펌웨어 버전 조회
        Firmware latest = firmwareRepository
                .findTopByModelNameOrderByCreatedAtDesc(device.getModelName())
                .orElseThrow(() -> new FirmwareException(FirmwareErrorCode.FIRMWARE_NOT_FOUND));

        // 4. 업데이트 로그 저장
        FirmwareUpdate updateLog = FirmwareUpdate.builder()
                .device(device)
                .beforeVersion(currentVersion)
                .afterVersion(latest.getLatestVersion())
                .status(FirmwareUpdateStatus.SUCCESS)
                .build();

        firmwareUpdateRepository.save(updateLog);

        // 5. 기기의 펌웨어 버전을 최신으로 업데이트
        device.updateFirmwareVersion(latest.getLatestVersion());
    }


    /* 07-03 새 펌웨어 등록 */
    @Override
    public FirmwareResDTO.FirmwareInfoDTO createFirmware(FirmwareReqDTO.RegisterFirmwareDTO request) {

        Firmware firmware = FirmwareConverter.toFirmware(request);
        firmwareRepository.save(firmware);

        return FirmwareConverter.toFirmwareInfoDTO(firmware);
    }

    /* 07-05 펌웨어 삭제 */
    @Override
    public void deleteFirmware(Long firmwareId) {
        Firmware firmware = firmwareRepository.findById(firmwareId)
                .orElseThrow(() -> new FirmwareException(FirmwareErrorCode.FIRMWARE_NOT_FOUND));

        firmwareRepository.delete(firmware);
    }
}
