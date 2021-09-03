package com.examportal.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.config.JwtUtils;
import com.examportal.model.JwtRequest;
import com.examportal.model.JwtResponse;
import com.examportal.model.User;
import com.examportal.services.Impl.UserDetailServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
	
	@Autowired
	private AuthenticationManager authenticationManger; 
	
	@Autowired
	private UserDetailServiceImpl userDetailService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest request) throws Exception{
		
		
		try {
			
			this.authenticate(request.getUsername(), request.getPassword());
		}
		catch(UsernameNotFoundException	 ex) {ex.printStackTrace(); throw new Exception("User not found");}
		
		
		UserDetails loadUserByUsername = this.userDetailService.loadUserByUsername(request.getUsername());
		
		String generateToken = this.jwtUtils.generateToken(loadUserByUsername);
		
		return ResponseEntity.ok(new JwtResponse(generateToken));
		
	}
	
	
	
	private void authenticate(String username, String password) throws Exception {
		
		try 
		{
			
		this.authenticationManger.authenticate(new UsernamePasswordAuthenticationToken(username,password));
		
		
		}
		catch(DisabledException ex) {
			
			throw new Exception("User Disabled "+ex.getMessage());
			
		}	catch(BadCredentialsException ex) {
			
			
			throw new Exception("Invalid Credentails "+ ex.getMessage());}
	}
	
	//Return the user details of current user
	
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		
		return ((User)this.userDetailService.loadUserByUsername(principal.getName()));
	} 

}
