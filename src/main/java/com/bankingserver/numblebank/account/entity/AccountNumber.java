package com.bankingserver.numblebank.account.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode(of = "number")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountNumber {

    private static final String ACCOUNT_REGEX = "^\\d{10}";

    @Column(nullable = false, unique = true, name = "account_number")
    private String number;

    public AccountNumber(String number) {
        validateAccountNumber(number);
        this.number = number;
    }

    private void validateAccountNumber(String number) {
        if(!number.matches(ACCOUNT_REGEX)) {
            throw new IllegalArgumentException("올바른 계좌번호가 아닙니다.");
        }
    }

    public static AccountNumber generateAccountNumber() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++) {
            sb.append((int) (Math.random() *9) + 1);
        }
        return new AccountNumber(sb.toString());
    }
}
