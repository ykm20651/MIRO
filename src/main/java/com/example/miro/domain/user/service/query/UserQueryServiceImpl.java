package com.example.miro.domain.user.service.query;

import com.example.miro.domain.user.code.UserErrorCode;
import com.example.miro.domain.user.converter.UserConverter;
import com.example.miro.domain.user.dto.res.UserResDTO;
import com.example.miro.domain.user.entity.User;
import com.example.miro.domain.user.exception.UserException;
import com.example.miro.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    @Override
    public UserResDTO.UserDetailDTO getUserInfo(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(()-> new UserException(UserErrorCode.USER_ID_NOT_FOUND));

        return UserConverter.toDetailDTO(user);

    }
}
