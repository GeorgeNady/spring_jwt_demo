package com.george.spring_jwt_demo.repository;

import com.george.spring_jwt_demo.table.UserX;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserX,Long> {
    UserX findByEmail(String email);
}
