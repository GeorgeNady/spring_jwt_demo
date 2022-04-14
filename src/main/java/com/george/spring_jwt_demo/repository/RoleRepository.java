package com.george.spring_jwt_demo.repository;

import com.george.spring_jwt_demo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
