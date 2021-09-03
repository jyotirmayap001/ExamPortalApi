package com.examportal.services.Impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.examportal.model.User;
import com.examportal.model.UserRole;
import com.examportal.repo.RoleRepository;
import com.examportal.repo.UserRepository;
import com.examportal.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	//Creating user here.
	@Override
	public User createUser(User user, Set<UserRole> userRole) throws Exception {

		
		User localUser=this.userRepository.findByemail(user.getEmail());
		
		if(localUser!=null) 
		{
			throw new Exception("User already present");
		}
		else 
		{
			
			//Create User
			for(UserRole role :userRole) {
				this.roleRepository.save(role.getRole());
			}
			
			//assign the roles to the users
			user.getUserRoles().addAll(userRole);
			
			//save the user
			localUser=this.userRepository.save(user);
			 
		}
		
		
		return localUser;
	}


	/* If User is not present in Cache then put ito cache and return to the controller*/
	@Override
	public User getUser(String email) {

		return this.userRepository.findByemail(email);
	}

}
