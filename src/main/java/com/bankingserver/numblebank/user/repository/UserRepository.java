package com.bankingserver.numblebank.user.repository;

import com.bankingserver.numblebank.user.entity.User;

import com.bankingserver.numblebank.user.entity.UserId;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUserId(UserId userId);

    Optional<User> findByUserId(UserId userId);
}
