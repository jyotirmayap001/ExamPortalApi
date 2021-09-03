package com.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.model.Role;
import com.examportal.model.UserRole;

public interface RoleRepository extends JpaRepository<Role, Long> {

	

}
