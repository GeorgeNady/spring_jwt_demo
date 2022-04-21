package com.george.spring_jwt_demo.service;

import com.george.spring_jwt_demo.table.RoleTable;
import com.george.spring_jwt_demo.table.UserTable;
import com.george.spring_jwt_demo.repository.RoleRepository;
import com.george.spring_jwt_demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor @Service @Transactional @Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;

    @Override
    public UserTable getUser(String email) {
        log.info("Fetching user {}", email);
        return userRepo.findByEmail(email);
    }

    @Override
    public List<UserTable> finUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }

    @Override
    public UserTable saveUser(UserTable userTable) {
        log.info("Save user {} into a database", userTable.getEmail());
        return userRepo.save(userTable);
    }

    @Override
    public RoleTable saveRole(RoleTable roleTable) {
        log.info("Save role {} into a database", roleTable.getName());
        return roleRepo.save(roleTable);
    }

    @Override
    public void addRoleToUser(String userEmail,String roleName) {
        log.info("Adding role {} to user {}", roleName, userEmail);
        UserTable userTable = userRepo.findByEmail(userEmail);
        RoleTable roleTable = roleRepo.findByName(roleName);
        userTable.getRoleTables().add(roleTable);
    }
}
