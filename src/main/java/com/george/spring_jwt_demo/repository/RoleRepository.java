package com.george.spring_jwt_demo.repository;

import com.george.spring_jwt_demo.table.RoleTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleTable, Long> {
    RoleTable findByName(String name);
}
