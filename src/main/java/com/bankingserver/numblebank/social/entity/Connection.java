package com.bankingserver.numblebank.social.entity;

import com.bankingserver.numblebank.common.BaseEntity;
import com.bankingserver.numblebank.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.Getter;

@Entity
@Getter
public class Connection extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_id", nullable = false)
    private User requester;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_id", nullable = false)
    private User receiver;

    private boolean approve;

    private LocalDateTime approveAt;

    public Connection(User requester, User receiver) {
        this.requester = requester;
        this.receiver = receiver;
        this.approve = false;
        this.approveAt = null;
    }
}
