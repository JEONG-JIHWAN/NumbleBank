package com.bankingserver.numblebank.user.entity;

import jakarta.persistence.AttributeConverter;

public class UserIdConvertor implements AttributeConverter<UserId, String> {

    @Override
    public String convertToDatabaseColumn(UserId attribute) {
        return attribute.getValue();
    }

    @Override
    public UserId convertToEntityAttribute(String dbData) {
        return UserId.valueOf(dbData);
    }
}
