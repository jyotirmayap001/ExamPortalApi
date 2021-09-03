package com.examportal.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="mstrole")
public class Role {
	
	@Id
	private Long roleid;
	private String rolename;
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="role")
	private Set<UserRole> userRoles=new HashSet<>();
	
	public Role() {}
	
	
	public Role(Long roleid, String rolename) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
	}


	
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}


	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}


	public Long getRoleid() {
		return roleid;
	}


	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}


	public String getRolename() {
		return rolename;
	}


	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	
	
	

}
