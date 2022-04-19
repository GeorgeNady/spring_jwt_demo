package com.george.spring_jwt_demo.service;

import com.george.spring_jwt_demo.table.Role;
import com.george.spring_jwt_demo.table.UserX;

import java.util.List;

public interface UserService {
    UserX getUser(String email);
    List<UserX> finUsers();
    UserX saveUser(UserX userX);
    Role saveRole(Role role);
    void addRoleToUser(String userEmail, String roleName);
}
