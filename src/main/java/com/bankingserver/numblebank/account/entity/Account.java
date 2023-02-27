package com.bankingserver.numblebank.account.entity;

import com.bankingserver.numblebank.common.BaseEntity;
import com.bankingserver.numblebank.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends BaseEntity {

    @ManyToOne
    private User user;
    @Column(nullable = false)
    private String password;
    @Embedded
    private AccountNumber accountNumber;
    @Embedded
    private Money money;

    public static Account createAccount(User user, String password) {
        return new Account(user, password, AccountNumber.generateAccountNumber(), Money.zero());
    }

    private Account(User user, String password, AccountNumber accountNumber, Money money) {
        this.user = user;
        this.password = password;
        this.accountNumber = accountNumber;
        this.money = money;
    }

}
