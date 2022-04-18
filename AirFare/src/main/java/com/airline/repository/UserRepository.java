package com.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
