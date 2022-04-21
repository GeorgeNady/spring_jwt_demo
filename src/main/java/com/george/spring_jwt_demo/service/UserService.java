package com.george.spring_jwt_demo.service;

import com.george.spring_jwt_demo.table.RoleTable;
import com.george.spring_jwt_demo.table.UserTable;

import java.util.List;

public interface UserService {
    UserTable getUser(String email);
    List<UserTable> finUsers();
    UserTable saveUser(UserTable userTable);
    RoleTable saveRole(RoleTable roleTable);
    void addRoleToUser(String userEmail, String roleName);
}
