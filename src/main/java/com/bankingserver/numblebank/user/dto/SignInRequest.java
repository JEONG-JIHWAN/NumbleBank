package com.bankingserver.numblebank.user.dto;

import com.bankingserver.numblebank.user.entity.Password;
import com.bankingserver.numblebank.user.entity.UserId;
import lombok.Getter;

@Getter
public class SignInRequest {
    private UserId userId;
    private Password password;
}
