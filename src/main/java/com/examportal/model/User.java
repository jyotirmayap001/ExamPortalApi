package com.examportal.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="mstuser")
public class User implements UserDetails
{
	
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private boolean isactive=true;
	private String userimage;
	
	
	//User have many roles
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="user")
	@JsonIgnore
	private Set<UserRole> userRoles=new HashSet<>();  
	
	
	
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}


	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}


	public User() {}
	
	
	public User(Long id, String username, String password, String firstname, String lastname, String email,
			String phone, boolean isactive, String userimage) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.isactive = isactive;
		this.userimage = userimage;
	}

	
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public boolean isIsactive() {
		return isactive;
	}


	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}


	public String getUserimage() {
		return userimage;
	}


	public void setUserimage(String userimage) {
		this.userimage = userimage;
	}

	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		
		Set<Authority> set=new HashSet<>();
		
		//Here from UserRoles list object we get one one rolename and add to the set
		this.userRoles.forEach(userrole->{
			
			set.add(new Authority(userrole.getRole().getRolename()));
			
		});
		 
		return set;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", phone=" + phone + ", isactive=" + isactive
				+ ", userimage=" + userimage + ", userRoles=" + userRoles + "]";
	}	
	
	
	
	

}
