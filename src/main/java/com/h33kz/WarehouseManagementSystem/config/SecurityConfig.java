package com.h33kz.WarehouseManagementSystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.h33kz.WarehouseManagementSystem.service.JpaUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  @Autowired
  private JpaUserDetailsService jpaUserDetailsService;

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    return http.authorizeHttpRequests(auth -> auth
      .requestMatchers(HttpMethod.POST).hasAuthority("ADMIN")
      .requestMatchers(HttpMethod.GET).hasAuthority("USER")
      .anyRequest().denyAll())
      .httpBasic(Customizer.withDefaults())
      .userDetailsService(jpaUserDetailsService)
      .build();
  }

  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
    // return NoOpPasswordEncoder.getInstance();
  }
}
