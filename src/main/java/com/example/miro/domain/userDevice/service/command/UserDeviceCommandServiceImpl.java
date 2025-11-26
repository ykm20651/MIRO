package com.example.miro.domain.userDevice.service.command;

import com.example.miro.domain.device.code.DeviceErrorCode;
import com.example.miro.domain.device.entity.Device;
import com.example.miro.domain.device.exception.DeviceException;
import com.example.miro.domain.device.repository.DeviceRepository;
import com.example.miro.domain.user.code.UserErrorCode;
import com.example.miro.domain.user.entity.User;
import com.example.miro.domain.user.exception.UserException;
import com.example.miro.domain.user.repository.UserRepository;
import com.example.miro.domain.userDevice.code.UserDeviceErrorCode;
import com.example.miro.domain.userDevice.converter.UserDeviceConverter;
import com.example.miro.domain.userDevice.dto.req.UserDeviceReqDTO;
import com.example.miro.domain.userDevice.dto.res.UserDeviceResDTO;
import com.example.miro.domain.userDevice.entity.UserDevice;
import com.example.miro.domain.userDevice.exception.UserDeviceException;
import com.example.miro.domain.userDevice.repository.UserDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserDeviceCommandServiceImpl implements UserDeviceCommandService {

    private final UserDeviceRepository userDeviceRepository;
    private final UserRepository userRepository;
    private final DeviceRepository deviceRepository;


    /* 03-01 사용자 기기 등록 */
    @Override
    public UserDeviceResDTO.UserDeviceInfoDTO createUserDevice(Long userId, UserDeviceReqDTO.CreateUserDeviceDTO request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException(UserErrorCode.USER_ID_NOT_FOUND));
        Device device = deviceRepository.findById(request.getDeviceId())
                .orElseThrow(() -> new DeviceException(DeviceErrorCode.DEVICE_NOT_FOUND));

        if(userDeviceRepository.existsByDeviceIdAndUserId(device.getId(), user.getId())){
            throw new UserDeviceException(UserDeviceErrorCode.USER_DEVICE_ALREADY_REGISTERED);
        }

        UserDevice userDevice = UserDeviceConverter.toUserDevice(user, device, request);
        userDeviceRepository.save(userDevice);

        return  UserDeviceConverter.toUserDeviceInfoDTO(userDevice);

    }

    /* 03-04 사용자 기기 설정 수정 */
    @Override
    public void updateUserDevice(Long userId, Long userDeviceId, UserDeviceReqDTO.UpdateUserDeviceDTO request) {

        UserDevice userDevice = userDeviceRepository.findByIdAndUserId(userDeviceId, userId)
                .orElseThrow(() -> new UserDeviceException(UserDeviceErrorCode.USER_DEVICE_NOT_FOUND));

        userDevice = UserDevice.builder()
                .id(userDevice.getId())
                .user(userDevice.getUser())
                .device(userDevice.getDevice())
                .defaultMode(request.getDefaultMode())
                .autoCleanEnabled(request.getAutoCleanEnabled())
                .isInitialized(true)
                .lastConnectedAt(userDevice.getLastConnectedAt())
                .build();

        userDeviceRepository.save(userDevice);
    }

    /* 03-05 사용자 기기 삭제 */
    @Override
    public void deleteUserDevice(Long userId, Long userDeviceId) {

        UserDevice userDevice = userDeviceRepository.findByIdAndUserId(userDeviceId, userId)
                .orElseThrow(() -> new UserDeviceException(UserDeviceErrorCode.USER_DEVICE_NOT_FOUND));

        userDeviceRepository.delete(userDevice);
    }

}
