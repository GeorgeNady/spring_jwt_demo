package com.george.spring_jwt_demo.service;

import com.george.spring_jwt_demo.table.Role;
import com.george.spring_jwt_demo.table.UserX;
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
    public UserX getUser(String email) {
        log.info("Fetching user {}", email);
        return userRepo.findByEmail(email);
    }

    @Override
    public List<UserX> finUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }

    @Override
    public UserX saveUser(UserX userX) {
        log.info("Save user {} into a database", userX.getEmail());
        return userRepo.save(userX);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Save role {} into a database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String userEmail,String roleName) {
        log.info("Adding role {} to user {}", roleName, userEmail);
        UserX userX = userRepo.findByEmail(userEmail);
        Role role = roleRepo.findByName(roleName);
        userX.getRoles().add(role);
    }
}
