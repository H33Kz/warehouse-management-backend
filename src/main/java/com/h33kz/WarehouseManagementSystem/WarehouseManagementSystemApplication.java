package com.h33kz.WarehouseManagementSystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.h33kz.WarehouseManagementSystem.models.User;
import com.h33kz.WarehouseManagementSystem.repository.UserRepository;

@SpringBootApplication
public class WarehouseManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarehouseManagementSystemApplication.class, args);
	}

  // @Bean
  // CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordEncoder passwordEncoder){
  //   return args->{
  //     User user = new User();
  //     user.setUsername("admin");
  //     user.setPassword(passwordEncoder.encode("admin"));
  //     user.setRoles("ADMIN,USER,MODERATOR");
  //     userRepository.save(user);
  //   };
  // }

}
