package com.example.miro.domain.userDevice.service.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class UserDeviceQueryServiceImpl implements UserDeviceQueryService {

}
