package com.george.spring_jwt_demo.repository;


import com.george.spring_jwt_demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
