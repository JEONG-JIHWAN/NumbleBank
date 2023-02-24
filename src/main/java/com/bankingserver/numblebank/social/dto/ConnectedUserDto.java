package com.bankingserver.numblebank.social.dto;

import com.bankingserver.numblebank.social.entity.Connection;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ConnectedUserDto {
    private Long connectionId;
    private Long id;
    private String userId;
    private LocalDateTime approvedAt;

    public ConnectedUserDto(Connection connection){
        this.connectionId = connection.getId();
        this.id = connection.getReceiver().getId();
        this.userId = connection.getReceiver().getUserId().getValue();
        this.approvedAt = connection.getApproveAt();
    }
}
