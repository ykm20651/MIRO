package com.example.miro.domain.firmware.service.query;

import com.example.miro.domain.firmware.code.FirmwareErrorCode;
import com.example.miro.domain.firmware.converter.FirmwareConverter;
import com.example.miro.domain.firmware.dto.res.FirmwareResDTO;
import com.example.miro.domain.firmware.entity.Firmware;
import com.example.miro.domain.firmware.exception.FirmwareException;
import com.example.miro.domain.firmware.repository.FirmwareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FirmwareQueryServiceImpl implements FirmwareQueryService {

    private final FirmwareRepository firmwareRepository;

    /* 07-01 최신 버전 조회 */
    @Override
    public FirmwareResDTO.LatestFirmwareDTO getLatestFirmware(String modelName) {

        Firmware firmware = firmwareRepository
                .findTopByModelNameOrderByCreatedAtDesc(modelName)
                .orElseThrow(() -> new FirmwareException(FirmwareErrorCode.FIRMWARE_NOT_FOUND));


        return FirmwareConverter.toLatestFirmwareDTO(firmware);
    }

    /* 07-04 전체 버전 리스트 조회 */
    @Override
    public List<FirmwareResDTO.FirmwareInfoDTO> getFirmwareList() {
        return firmwareRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(FirmwareConverter::toFirmwareInfoDTO)
                .toList();
    }
}
