package com.bankingserver.numblebank.social.controller;

import com.bankingserver.numblebank.social.dto.ConnectedUserDto;
import com.bankingserver.numblebank.social.service.ConnectionService;
import com.bankingserver.numblebank.user.auth.CurrentUser;
import com.bankingserver.numblebank.user.entity.User;
import com.bankingserver.numblebank.user.entity.UserId;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("friends")
@RequiredArgsConstructor
public class ConnectionController {
    private final ConnectionService connectionService;
    @PostMapping("add")
    public void addFriend(@CurrentUser User user, @RequestBody Map<String, UserId> addFriendRequest){
        UserId receiverId = addFriendRequest.get("receiverId");
        connectionService.addFriend(user, receiverId);
    }

}
