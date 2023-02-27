package com.bankingserver.numblebank.user.entity;

import com.bankingserver.numblebank.account.entity.Account;
import com.bankingserver.numblebank.account.entity.AccountPassword;
import com.bankingserver.numblebank.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @Convert(converter = UserIdConvertor.class)
    @Column(columnDefinition = "varchar(80)", unique = true, nullable = false)
    private UserId userId;
    @Column(columnDefinition = "varchar(80)", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Account> account;

    public User(UserId userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public void addAccount(Account account) {
        this.account.add(account);
    }
}
