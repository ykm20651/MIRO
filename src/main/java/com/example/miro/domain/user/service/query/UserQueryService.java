package com.example.miro.domain.user.service.query;

import com.example.miro.domain.user.dto.res.UserResDTO;

public interface UserQueryService {
    UserResDTO.UserDetailDTO getUserInfo(Long userId);
}
