package org.example.sprbasic.repository;

import org.example.sprbasic.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
