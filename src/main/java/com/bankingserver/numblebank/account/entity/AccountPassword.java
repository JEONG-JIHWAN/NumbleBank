package com.bankingserver.numblebank.account.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountPassword {

    private static final String ACCOUNT_PASSWORD_REGEX = "^\\d{4}";
    private String value;

    public AccountPassword(String value) {
        validateAccountPassword(value);
        this.value = value;
    }

    private void validateAccountPassword(String value) {
        if(!value.matches(ACCOUNT_PASSWORD_REGEX)) {
            throw new IllegalArgumentException("계좌 비밀번호는 4자리 숫자여야합니다.");
        }
    }
}
