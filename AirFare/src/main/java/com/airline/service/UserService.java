package com.airline.service;

import java.util.List;
import java.util.Set;

import com.airline.model.User;
import com.airline.model.UserRole;

public interface UserService {

    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    public User getUser(String username);

    //delete user by id
    public  void deleteUser(long userId);

    //update user by id
    public User updateUser(User user,long userId);
}
