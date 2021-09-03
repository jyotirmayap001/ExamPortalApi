package com.examportal.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examportal.services.Impl.UserDetailServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private UserDetailServiceImpl userDetailService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		System.out.println(requestTokenHeader);
		
		String username=null;
		String jwtToken=null;
		
		 if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ") ) 
		 {
			 jwtToken=requestTokenHeader.substring(7);
			 
			 try 
			 {
			  username = this.jwtUtils.extractUsername(jwtToken);
			  
			 }
			 catch(ExpiredJwtException ex) 
			 {
				 ex.printStackTrace();
				 System.out.println("Token Expired");
			 }
			 catch(Exception e) { System.out.println("Error"); }
		 }
		 else 
		 {
			 
			 System.out.println("Invalid token, start with bearer");
		 }
		 
		 if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) 
		 {
			 final UserDetails loadUserByUsername = this.userDetailService.loadUserByUsername(username);
			 
			 if(this.jwtUtils.validateToken(jwtToken, loadUserByUsername) )
			 {
				 
				 UsernamePasswordAuthenticationToken
				 
				 userNamePasswordAuthenticationFilter=
				 
				 new UsernamePasswordAuthenticationToken(loadUserByUsername,null,loadUserByUsername.getAuthorities());
				 
				 userNamePasswordAuthenticationFilter.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				 
				 
				 SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthenticationFilter);
				 
			 }
			 else {System.out.println("Token is not valid");}
		 }
		 
		 //Forward the request 
		 filterChain.doFilter(request, response);
		
	}

}
