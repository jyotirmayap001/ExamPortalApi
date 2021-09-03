package com.examportal.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="userrole")
public class UserRole {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userroleid;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private User user;

	@ManyToOne
	private Role role;
	
	public UserRole() {}
	
	
	
	
	public UserRole(Long userroleid, User user) {
		super();
		this.userroleid = userroleid;
		this.user = user;
		
	}

	
	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}
	
	public Long getUserroleid() {
		return userroleid;
	}

	public void setUserroleid(Long userroleid) {
		this.userroleid = userroleid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		

	
	
	
}
