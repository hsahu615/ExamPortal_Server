package com.exam;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication {
	@Autowired
	public UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}


//	@Override
//	public void run(String... args) throws Exception {
//		User user = new User();
//		user.setEmail("hsahu76");
//		user.setEnabled(true);
//		user.setFirstName("Himanshu");
//		user.setLastName("Sahu");
//		user.setPassword("abc");
//		user.setUsername("hsahu615");
//		user.setProfile("sdvsdv");
//
//		Role role = new Role();
//		role.setRoleId(44L);
//		role.setRoleName("ADMIN");
//
//		Set<UserRole> roles = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//
//		roles.add(userRole);
//
//		user.setUserRoles(roles);
//
//		User user1 = this.userService.createUser(user, roles);
//		System.out.println(user1.getUsername());
//	}
}
