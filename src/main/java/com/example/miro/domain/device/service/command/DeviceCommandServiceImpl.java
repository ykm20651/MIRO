package com.example.miro.domain.device.service.command;

import com.example.miro.domain.device.code.DeviceErrorCode;
import com.example.miro.domain.device.converter.DeviceConverter;
import com.example.miro.domain.device.dto.req.DeviceReqDTO;
import com.example.miro.domain.device.dto.res.DeviceResDTO;
import com.example.miro.domain.device.entity.Device;
import com.example.miro.domain.device.exception.DeviceException;
import com.example.miro.domain.device.repository.DeviceRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional //클래스 안의 모든 public 메서드에 붙어짐. 진행되는 모든 DB 작업을 하나의 트랜잭션 단위로 관리하여 일관성 보장
public class DeviceCommandServiceImpl implements DeviceCommandService {

    private final DeviceRepository deviceRepository;

    /* 02-01 기기 등록 */
    @Override
    public DeviceResDTO.DeviceInfoDTO createDevice(Long adminId, DeviceReqDTO.CreateDeviceDTO request) {

        if (deviceRepository.existsBySerialNumber(request.getSerialNumber())) {
            throw new DeviceException(DeviceErrorCode.DEVICE_ALREADY_REGISTERED);
        }

        Device device = DeviceConverter.toDevice(request);
        deviceRepository.save(device);

        return DeviceConverter.toDeviceInfoDTO(device);
    }

    /* 02-04 기기 수정 */
    @Override
    public void updateDevice(Long adminId, Long deviceId, DeviceReqDTO.UpdateDeviceDTO request) {

        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new DeviceException(DeviceErrorCode.DEVICE_NOT_FOUND));

        device = Device.builder()
                .id(device.getId())
                .serialNumber(device.getSerialNumber())
                .modelName(request.getModelName())
                .firmwareVersion(request.getFirmwareVersion())
                .build();

        deviceRepository.save(device);
    }

    /* 02-05 기기 삭제 */
    @Override
    public void deleteDevice(Long adminId, Long deviceId) {

        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new DeviceException(DeviceErrorCode.DEVICE_NOT_FOUND));

        deviceRepository.delete(device);
    }
}
