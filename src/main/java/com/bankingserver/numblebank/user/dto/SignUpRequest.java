package com.bankingserver.numblebank.user.dto;

import com.bankingserver.numblebank.user.entity.Password;
import com.bankingserver.numblebank.user.entity.UserId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    private UserId userId;
    private Password password;

}
