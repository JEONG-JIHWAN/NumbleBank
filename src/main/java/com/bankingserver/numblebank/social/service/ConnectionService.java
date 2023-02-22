package com.bankingserver.numblebank.social.service;

import com.bankingserver.numblebank.social.dto.ConnectedUserDto;
import com.bankingserver.numblebank.social.entity.Connection;
import com.bankingserver.numblebank.social.repository.ConnectionRepository;
import com.bankingserver.numblebank.user.entity.User;
import com.bankingserver.numblebank.user.entity.UserId;
import com.bankingserver.numblebank.user.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConnectionService {
    private final ConnectionRepository connectionRepository;
    private final UserRepository userRepository;


    public void addFriend(User user, UserId receiverUserId) {
        Optional<User> receiver = userRepository.findByUserId(receiverUserId);
        receiver.ifPresent( r-> connectionRepository.save(new Connection(user, r)));

    }
}
