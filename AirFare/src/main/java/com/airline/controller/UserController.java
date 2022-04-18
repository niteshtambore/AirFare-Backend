package com.airline.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.airline.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.airline.model.Role;
import com.airline.model.User;
import com.airline.model.UserRole;
import com.airline.service.UserService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;


    //creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        user.setProfile("default.png");

        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        return this.userService.createUser(user, roles);
    }

    //get user by name API
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }

    //delete API
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId")long userId) {
        this.userService.deleteUser(userId);
    }

    //update API
        @PutMapping("/{userId}")
        public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("userId") int userId)
        {
            try{
                this.userService.updateUser(user,userId);
                return ResponseEntity.status(HttpStatus.OK).body(user);
            }catch(Exception e){
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }

        }


}
