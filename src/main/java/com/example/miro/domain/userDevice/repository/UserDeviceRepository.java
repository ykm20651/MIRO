package com.example.miro.domain.userDevice.repository;

import com.example.miro.domain.device.entity.Device;
import com.example.miro.domain.user.entity.User;
import com.example.miro.domain.userDevice.entity.UserDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDeviceRepository extends JpaRepository<UserDevice,Long> {
    Optional<UserDevice> findByUserAndDevice(User user, Device device);
    List<UserDevice> findAllByUser(User user);
}
