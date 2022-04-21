package com.george.spring_jwt_demo.repository;

import com.george.spring_jwt_demo.table.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserTable,Long> {
    UserTable findByEmail(String email);
}
