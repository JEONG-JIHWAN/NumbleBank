package com.bankingserver.numblebank.user.service;


import com.bankingserver.numblebank.user.entity.Password;
import com.bankingserver.numblebank.user.entity.UserId;

public interface UserService {

    void join(UserId userId, Password password);
}
