package com.george.spring_jwt_demo.service;

import com.george.spring_jwt_demo.table.Role;
import com.george.spring_jwt_demo.table.User;

import java.util.List;

public interface UserService {
    User getUser(String email);
    List<User> finUsers();
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String userEmail, String roleName);
}
