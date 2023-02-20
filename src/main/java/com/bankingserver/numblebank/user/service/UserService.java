package com.bankingserver.numblebank.user.service;

import com.bankingserver.numblebank.user.auth.TokenUtils;
import com.bankingserver.numblebank.user.dto.SignInRequest;
import com.bankingserver.numblebank.user.dto.SignUpRequest;
import com.bankingserver.numblebank.user.entity.User;
import com.bankingserver.numblebank.user.entity.UserId;
import com.bankingserver.numblebank.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final TokenUtils tokenUtils;
    private final AuthenticationManager authenticationManager;

    public void join(SignUpRequest signUpRequest) {
        UserId userId = signUpRequest.getUserId();
        checkExistUserId(userId);
        String encodedPassword = passwordEncoder.encode(signUpRequest.getPassword().getValue());
        userRepository.save(new User(userId, encodedPassword));
    }

    public String login(SignInRequest signInRequest) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(signInRequest.getUserId().getValue(), signInRequest.getPassword().getValue());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        return tokenUtils.generateJwtToken(authentication);
    }

    private void checkExistUserId(UserId userId) {
        if(userRepository.existsByUserId(userId)){
            throw new IllegalArgumentException("해당 사용자가 이미 존재합니다.");
        }
    }


}
