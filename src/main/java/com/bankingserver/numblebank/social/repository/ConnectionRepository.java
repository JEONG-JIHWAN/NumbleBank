package com.bankingserver.numblebank.social.repository;

import com.bankingserver.numblebank.social.dto.ConnectedUserDto;
import com.bankingserver.numblebank.social.entity.Connection;
import com.bankingserver.numblebank.user.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConnectionRepository extends JpaRepository<Connection, Long> {
    @Query("select c from Connection c join c.requester join c.receiver where c.requester = :requester and c.receiver = :receiver")
    Connection findByRequesterAndReceiver(@Param("requester") User requester, @Param("receiver") User receiver);
}
