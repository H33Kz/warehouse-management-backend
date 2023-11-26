package com.h33kz.WarehouseManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.h33kz.WarehouseManagementSystem.models.User;
import com.h33kz.WarehouseManagementSystem.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public User addUser(User user){
    if(userRepository.findByUsername(user.getUsername())==null){
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      return userRepository.save(user);
    }
    else{
      return null;
    }
  }
}
