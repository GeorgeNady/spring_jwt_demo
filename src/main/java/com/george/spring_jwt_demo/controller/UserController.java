package com.george.spring_jwt_demo.controller;

import com.george.spring_jwt_demo.model.BaseResponse;
import com.george.spring_jwt_demo.table.RoleTable;
import com.george.spring_jwt_demo.table.UserTable;
import com.george.spring_jwt_demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController @RequiredArgsConstructor @RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<BaseResponse<List<UserTable>>> getUsers() {
        List<UserTable> userTables = userService.finUsers();

        return ResponseEntity.ok().body(response(userTables, "users fetched successfully!"));
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<BaseResponse<UserTable>> getUser(@PathVariable("email") String email) {
        UserTable userTable = userService.getUser(email);

        return ResponseEntity.ok().body(response(userTable, "user fetched successfully!"));
    }

    @PostMapping("/user/create")
    public ResponseEntity<BaseResponse<UserTable>> saveUser(@RequestBody UserTable userTable) {
        UserTable createdUserTable = userService.saveUser(userTable);
        URI uri = generateUri("/user/create");

        return ResponseEntity.created(uri).body(response(createdUserTable, "user created successfully!"));
    }

    @PostMapping("/role/create")
    public ResponseEntity<BaseResponse<RoleTable>> saveRole(@RequestBody RoleTable roleTable) {
        RoleTable createdRoleTable = userService.saveRole(roleTable);
        URI uri = generateUri(("/role/create"));

        return ResponseEntity.created(uri).body(response(createdRoleTable, "role created successfully!"));
    }

    @PostMapping("/user/add_role/{email}")
    public ResponseEntity<BaseResponse<?>> addRoleToUser(@RequestBody RoleToUser roleToUser) {
        userService.addRoleToUser(roleToUser.email,roleToUser.roleName);
        return ResponseEntity.ok().body(response(null, "role added successfully!"));
    }

    @Contract("_ -> new")
    private @NotNull URI generateUri(String path) {
        return URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api" + path).toUriString());
    }


    @Contract("_, _ -> new")
    private <D> @NotNull BaseResponse<D> response(D data, String message) {
        return new BaseResponse<>(true,data, message);
    }

    @Getter
    @AllArgsConstructor
    static class RoleToUser {
        private String email;
        private String roleName;
    }

}
