package com.h33kz.WarehouseManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.h33kz.WarehouseManagementSystem.models.SecurityUser;
import com.h33kz.WarehouseManagementSystem.repository.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService{
  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    return userRepository.findByUsername(username)
              .map(SecurityUser::new)
              .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }
}
