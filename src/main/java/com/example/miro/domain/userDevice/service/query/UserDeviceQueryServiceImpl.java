package com.example.miro.domain.userDevice.service.query;

import com.example.miro.domain.userDevice.code.UserDeviceErrorCode;
import com.example.miro.domain.userDevice.converter.UserDeviceConverter;
import com.example.miro.domain.userDevice.dto.res.UserDeviceResDTO;
import com.example.miro.domain.userDevice.entity.UserDevice;
import com.example.miro.domain.userDevice.exception.UserDeviceException;
import com.example.miro.domain.userDevice.repository.UserDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class UserDeviceQueryServiceImpl implements UserDeviceQueryService {
    private final UserDeviceRepository userDeviceRepository;

    /* 03-02 사용자 기기 목록 조회 */
    @Override
    public List<UserDeviceResDTO.UserDeviceInfoDTO> getMyDevices(Long userId) {

        return userDeviceRepository.findAllByUserId(userId).stream()
                .map(UserDeviceConverter::toUserDeviceInfoDTO)
                .toList();
    }

    /* 03-03 사용자 기기 상세 조회 */
    @Override
    public UserDeviceResDTO.UserDeviceInfoDTO getMyDevice(Long userId, Long userDeviceId) {

        UserDevice userDevice = userDeviceRepository.findByIdAndUserId(userDeviceId, userId)
                .orElseThrow(() -> new UserDeviceException(UserDeviceErrorCode.USER_DEVICE_NOT_FOUND));

        return UserDeviceConverter.toUserDeviceInfoDTO(userDevice);
    }

}
