package com.george.spring_jwt_demo;

import com.george.spring_jwt_demo.service.UserService;
import com.george.spring_jwt_demo.table.RoleTable;
import com.george.spring_jwt_demo.table.UserTable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringJwtDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtDemoApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return run -> {
			userService.saveRole(new RoleTable(null,"ROLE_USER"));
			userService.saveRole(new RoleTable(null,"ROLE_MANAGER"));
			userService.saveRole(new RoleTable(null,"ROLE_ADMIN"));
			userService.saveRole(new RoleTable(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new UserTable(null,"George","george@gmail.com","1234",new ArrayList<>()));
			userService.saveUser(new UserTable(null,"Joseph","joseph@gmail.com","1234",new ArrayList<>()));
			userService.saveUser(new UserTable(null,"Caroline","caroline@gmail.com","1234",new ArrayList<>()));
			userService.saveUser(new UserTable(null,"Marian","marian@gmail.com","1234",new ArrayList<>()));

			userService.addRoleToUser("george@gmail.com","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("george@gmail.com","ROLE_MANAGER");
			userService.addRoleToUser("george@gmail.com","ROLE_USER");

			userService.addRoleToUser("joseph@gmail.com","ROLE_ADMIN");
			userService.addRoleToUser("joseph@gmail.com","ROLE_USER");

			userService.addRoleToUser("caroline@gmail.com","ROLE_USER");
			userService.addRoleToUser("Marian@gmail.com","ROLE_USER");
		};
	}

}
