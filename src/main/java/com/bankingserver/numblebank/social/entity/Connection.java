package com.bankingserver.numblebank.social.entity;

import com.bankingserver.numblebank.common.BaseEntity;
import com.bankingserver.numblebank.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Connection extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_id", nullable = false)
    private User requester;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_id", nullable = false)
    private User receiver;

    private boolean approve;

    private LocalDateTime approveAt;

    public static Connection makeConnection(User requester, User receiver) {
        return new Connection(requester, receiver, false, null);
    }

    public static Connection approveConnection(User requester, User receiver) {
        return new Connection(requester, receiver, true, LocalDateTime.now());
    }

    public void acceptFriend() {
        this.approve = true;
        this.approveAt = LocalDateTime.now();
    }
}
