package com.examportal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.examportal.model.Role;
import com.examportal.model.User;
import com.examportal.model.UserRole;
import com.examportal.model.exam.Category;
import com.examportal.services.UserService;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner {

	
	 
	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		/*
		 * System.out.println("Start the code");
		 * 
		 * User user = new User();
		 * 
		 * user.setFirstname("Jyotirmaya");user.setLastname("Pati");user.setEmail(
		 * "jyotirmayap001@gmail.com");
		 * user.setPassword(this.bcryptPasswordEncoder.encode("jyoti@123"));user.
		 * setPhone("8260573129");user.setUserimage( "default.png");
		 * user.setUsername("jyotirmayap001");
		 * 
		 * Role role=new Role(); role.setRoleid(1L); role.setRolename("ADMIN");
		 * 
		 * Set<UserRole> userRoleSet=new HashSet<>(); UserRole userRole=new UserRole();
		 * userRole.setRole(role); userRole.setUser(user);
		 * 
		 * userRoleSet.add(userRole);
		 * 
		 * User createUser = this.userService.createUser(user, userRoleSet);
		 * 
		 * System.out.println(createUser.getEmail()+"-->"+createUser.getPassword());
		 */
		 
	}

}
