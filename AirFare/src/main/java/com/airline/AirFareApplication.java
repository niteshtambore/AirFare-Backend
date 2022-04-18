package com.airline;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.airline.model.Role;
import com.airline.model.User;
import com.airline.model.UserRole;
import com.airline.service.UserService;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class AirFareApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;
    
    public static void main(String[] args) {

        SpringApplication.run(AirFareApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
        	System.out.println("starting code");

//            User user = new User();
//
//            user.setFirstName("Durgesh");
//            user.setLastName("Tiwari");
//            user.setUsername("durgesh8896");
//            user.setPassword("1235");
//            user.setEmail("abc@gmail.com");
//            user.setProfile("default.png");
//
//            Role role1 = new Role();
//            role1.setRoleId(44L);
//            role1.setRoleName("ADMIN");
//
//            Set<UserRole> userRoleSet = new HashSet<>();
//            UserRole userRole = new UserRole();
//
//            userRole.setRole(role1);
//
//            userRole.setUser(user);
//
//            userRoleSet.add(userRole);
//
//            User user1 = this.userService.createUser(user, userRoleSet);
//            System.out.println(user1.getUsername());


        } catch (Exception e) {
            e.printStackTrace();


        }


    }


}
