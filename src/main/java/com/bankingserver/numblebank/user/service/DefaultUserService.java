package com.bankingserver.numblebank.user.service;

import com.bankingserver.numblebank.user.entity.Password;
import com.bankingserver.numblebank.user.entity.User;
import com.bankingserver.numblebank.user.entity.UserId;
import com.bankingserver.numblebank.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DefaultUserService implements UserService{
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void join(UserId userId, Password password) {
        checkExistUserId(userId);
        String encodedPassword = passwordEncoder.encode(password.getValue());
        userRepository.save(new User(userId, encodedPassword));
    }

    private void checkExistUserId(UserId userId) {
        if(userRepository.existsByUserId(userId)){
            throw new IllegalArgumentException("해당 사용자가 이미 존재합니다.");
        }
    }


}
