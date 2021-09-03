package com.examportal.controller;




import java.io.File;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.examportal.config.FileUploadHandler;
import com.examportal.model.Role;
import com.examportal.model.User;
import com.examportal.model.UserRole;
import com.examportal.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	private FileUploadHandler fileHandler; 
	
	@Autowired
	private ServletContext servletContext;
	
	//Creating User
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		
		user.setPassword(this.bcryptPasswordEncoder.encode(user.getPassword()));
		
		Set<UserRole> userRole=new HashSet<>();
		
		
		Role role=new Role();
		
		role.setRoleid(2L);
		role.setRolename("NORMAL");
		
		UserRole userRoles=new UserRole();
		
		userRoles.setUser(user);
		userRoles.setRole(role);
		
		userRole.add(userRoles);
		
		
		return this.userService.createUser(user, userRole);
		
	}
	
	
	@GetMapping("/{emailid}")
	public User getUser(@PathVariable("emailid") String email) {
		
		return this.userService.getUser(email);
	}
	
	@PostMapping(path="/updateData")
	public ResponseEntity<String> updateUserData(@RequestParam("userimage") MultipartFile file) {
		
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		try {
		
				if(file.isEmpty())
				{
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please choose any file");
				}
				
				if(!(file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png") ) ) {
					
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please upload only jpeg or png file");
				}
				
				
				
				boolean uploadFile = this.fileHandler.uploadFile(file);
		
				
				if(uploadFile) {
					
					
					
					return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("static/image/").
							path(file.getOriginalFilename()).toUriString());
				}
				
		
		}
		catch(Exception ex) {ex.printStackTrace();}
		
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
	}

}
