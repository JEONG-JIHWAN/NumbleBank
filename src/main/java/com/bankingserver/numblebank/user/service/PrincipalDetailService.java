package com.bankingserver.numblebank.user.service;

import com.bankingserver.numblebank.user.auth.PrincipalDetails;
import com.bankingserver.numblebank.user.entity.User;
import com.bankingserver.numblebank.user.entity.UserId;
import com.bankingserver.numblebank.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        User byUserId = userRepository.findByUserId(UserId.valueOf(userid));
        if(byUserId == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        return new PrincipalDetails(byUserId);
    }
}
