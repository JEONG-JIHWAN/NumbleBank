package com.bankingserver.numblebank.user.entity;

import com.bankingserver.numblebank.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
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

    public User(UserId userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
