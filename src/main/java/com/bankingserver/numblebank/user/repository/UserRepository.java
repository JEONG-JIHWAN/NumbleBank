package com.bankingserver.numblebank.user.repository;

import com.bankingserver.numblebank.user.entity.User;

import com.bankingserver.numblebank.user.entity.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUserId(UserId userId);
}
