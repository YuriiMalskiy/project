package com.malskyi.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.malskyi.project.entity.UserEntity;
import com.malskyi.project.entity.enums.Roles;
import com.malskyi.project.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.malskyi.project.repository")
public class ProjectApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		if(userRepository.count() == 0) {
			UserEntity user = new UserEntity();
			user.setUsername("admin");
			user.setFirstName("Admin");
			user.setLastName("Admin");
			user.setRole(Roles.ROLE_GLOBAL_ADMIN);
			user.setPassword(passwordEncoder.encode("admin"));
			
			userRepository.save(user);
		}
		
	}
}

