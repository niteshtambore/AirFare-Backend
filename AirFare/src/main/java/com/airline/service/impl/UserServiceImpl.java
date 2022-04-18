package com.airline.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.model.User;
import com.airline.model.UserRole;
import com.airline.repository.RoleRepository;
import com.airline.repository.UserRepository;
import com.airline.service.UserService;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {


        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User is already there !!");
            throw new Exception();
        } else {
            //user create
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);

        }

        return local;
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(long userId) {
        this.userRepository.deleteById(userId);
    }

//    public User updateUser(User user, long userId) {
//        user.setId(userId);
//        user=this.userRepository.save(user);
//        System.out.println(user);
//        return user;
//    }

    public User updateUser(User user,long userId) {
        user.setId(userId);             //have to enter id also in postman so that the id will match and then values will be updated
        user=userRepository.save(user);
        System.out.println(user);
        return user;
    }


}
