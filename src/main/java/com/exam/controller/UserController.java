package com.exam.controller;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    // creating user
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
        if(user.getProfile()==null) user.setProfile("default.png");
        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);

        Set<UserRole> roles = new HashSet<>();
        roles.add(userRole);
        return new ResponseEntity<>(this.userService.createUser(user, roles), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) throws Exception{
        return this.userService.getUser(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }
}

