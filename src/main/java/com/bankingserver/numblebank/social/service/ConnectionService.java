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
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ConnectionService {
    private final ConnectionRepository connectionRepository;
    private final UserRepository userRepository;


    @Transactional
    public void addFriend(User user, UserId receiverUserId) {
        Optional<User> receiver = userRepository.findByUserId(receiverUserId);
        receiver.ifPresentOrElse( r-> connectionRepository.save(
                Connection.makeConnection(user, r)), () -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));

    }

    @Transactional
    public void approveFriend(User user, Long approvedId) {
        User approvedUser = checkExistsUserById(approvedId);
        Connection notApproveConnection = connectionRepository.findByRequesterAndReceiver(user, approvedUser);
        notApproveConnection.acceptFriend();
        connectionRepository.save(Connection.approveConnection(approvedUser, user));
    }

    public List<Connection> findAllConnectedUser(User user) {
        return connectionRepository.findAllConnectionByUser(user);
    }

    private User checkExistsUserById(Long id) {
        Optional<User> byId= userRepository.findById(id);
        if(byId.isEmpty()){
            throw new IllegalArgumentException("");
        }
        return byId.get();
    }
}
