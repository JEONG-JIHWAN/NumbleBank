package com.bankingserver.numblebank.user.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class UserId {
    private final String value;

    @JsonCreator
    public static UserId valueOf(@JsonProperty("userId") String value) {
        return new UserId(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserId userId = (UserId) o;
        return Objects.equals(value, userId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
