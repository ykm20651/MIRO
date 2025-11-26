package com.example.miro.domain.device.service.command;

import com.example.miro.domain.device.converter.DeviceConverter;
import com.example.miro.domain.device.dto.req.DeviceReqDTO;
import com.example.miro.domain.device.dto.res.DeviceResDTO;
import com.example.miro.domain.device.entity.Device;
import com.example.miro.domain.device.repository.DeviceRepository;
import com.example.miro.domain.user.code.UserErrorCode;
import com.example.miro.domain.user.entity.User;
import com.example.miro.domain.user.exception.UserException;
import com.example.miro.domain.user.repository.UserRepository;
import com.example.miro.domain.userDevice.code.UserDeviceErrorCode;
import com.example.miro.domain.userDevice.entity.UserDevice;
import com.example.miro.domain.userDevice.enums.CleanMode;
import com.example.miro.domain.userDevice.exception.UserDeviceException;
import com.example.miro.domain.userDevice.repository.UserDeviceRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional //클래스 안의 모든 public 메서드에 붙어짐. 진행되는 모든 DB 작업을 하나의 트랜잭션 단위로 관리하여 일관성 보장
public class DeviceCommandServiceImpl implements DeviceCommandService {

    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;
    private final UserDeviceRepository userDeviceRepository;

    @Override
    public DeviceResDTO.DeviceInfoDTO registerDevice(
            Long userId,
            DeviceReqDTO.DeviceRegisterDTO dto
    ){
        //1. 유저 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException(UserErrorCode.USER_ID_NOT_FOUND));

        //2. 기기 조회하고 없으면 생성 - orElseGet() = 값이 없으면 필요할 때 그제서야 함수로 생성
        Device device = deviceRepository.findBySerialNumber(dto.getSerialNumber())
                .orElseGet( () -> deviceRepository.save(DeviceConverter.toDevice(dto)));

        //3. 이미 사용자 기기에 등록된거인지 체크
        userDeviceRepository.findByUserAndDevice(user, device).ifPresent(userDevice -> {
            throw new UserDeviceException(UserDeviceErrorCode.USER_DEVICE_ALREADY_REGISTERED);
        });

        // 4. UserDevice 생성
        UserDevice userDevice = userDeviceRepository.save(
                UserDevice.builder()
                        .user(user)
                        .device(device)
                        .defaultMode(CleanMode.AUTO)
                        .autoCleanEnabled(false)
                        .isInitialized(false)
                        .build()
        );

        return DeviceConverter.toDeviceInfoDTO(device, userDevice);
    }


}
