package com.airline.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
	
}
