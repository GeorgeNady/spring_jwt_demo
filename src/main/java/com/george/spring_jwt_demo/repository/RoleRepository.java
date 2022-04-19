package com.george.spring_jwt_demo.repository;

import com.george.spring_jwt_demo.table.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
