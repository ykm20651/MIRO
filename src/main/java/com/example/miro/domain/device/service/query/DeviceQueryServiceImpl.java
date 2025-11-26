package com.example.miro.domain.device.service.query;

import com.example.miro.domain.device.code.DeviceErrorCode;
import com.example.miro.domain.device.converter.DeviceConverter;
import com.example.miro.domain.device.dto.res.DeviceResDTO;
import com.example.miro.domain.device.entity.Device;
import com.example.miro.domain.device.exception.DeviceException;
import com.example.miro.domain.device.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DeviceQueryServiceImpl implements DeviceQueryService {

    private final DeviceRepository deviceRepository;

    /* 02-02 상세 조회 */
    @Override
    public DeviceResDTO.DeviceInfoDTO getDevice(Long userId, Long deviceId) {

        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new DeviceException(DeviceErrorCode.DEVICE_NOT_FOUND));

        return DeviceConverter.toDeviceInfoDTO(device);
    }

    /* 02-03 목록 조회 */
    @Override
    public List<DeviceResDTO.DeviceInfoDTO> getAllDevices(Long userId) {

        return deviceRepository.findAll().stream()
                .map(DeviceConverter::toDeviceInfoDTO)
                .toList();
    }
}
