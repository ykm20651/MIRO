package com.example.miro.domain.userDevice.repository;

import com.example.miro.domain.userDevice.entity.UserDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDeviceRepository extends JpaRepository<UserDevice,Long> {

    // 특정 사용자에게 등록된 기기 목록
    List<UserDevice> findAllByUserId(Long userId);

    // 특정 기기가 특정 사용자에게 속해 있는지 검증
    Optional<UserDevice> findByIdAndUserId(Long id, Long userId);

    // 같은 기기를 중복 등록하지 못하도록
    boolean existsByDeviceIdAndUserId(Long deviceId, Long userId);
}
