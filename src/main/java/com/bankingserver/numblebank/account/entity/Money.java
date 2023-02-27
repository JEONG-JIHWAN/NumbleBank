package com.bankingserver.numblebank.account.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Money {
    @Column(nullable = false, name = "money")
    private long value;

    public Money (long value) {
        validateMoney(value);
        this.value = value;
    }

    public static Money zero() {
        return new Money(0);
    }

    private void validateMoney(long value) {
        if(value<0){
            throw new IllegalArgumentException("계좌의 돈은 0원 미만일 수 없습니다.");
        }
    }

    public long plus(long value) {
        this.value += value;
        return this.value;
    }

    public long minus(long value){
        if(this.value - value <0) {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
        this.value -= value;
        return this.value;
    }
}
