package com.h33kz.WarehouseManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.h33kz.WarehouseManagementSystem.exceptions.UserAlreadyExistsException;
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
      throw new UserAlreadyExistsException("User with this username already exists in DB");
    }
  }

  public void removeUser(String username){
    User user = userRepository.findByUsername(username).orElse(null);
    if(user != null){
      userRepository.delete(user);
    }else{
      throw new UsernameNotFoundException("User not found");
    }
  }

  public User changePasswordForCurrentlyLoggedUser(String newPassword){
    User user = checkAuthorizedUser();
    user.setPassword(passwordEncoder.encode(newPassword));
    return userRepository.save(user);
  }

  public User changeEmailForCurrentlyLoggedUser(String newEmail){
    User user = checkAuthorizedUser();
    user.setEmail(newEmail);
    return userRepository.save(user);
  }

  public User changeRolesForCurrentlyLoggedUser(String newRoles){
    User user = checkAuthorizedUser();
    user.setRoles(newRoles);
    return userRepository.save(user);
  }

  private User checkAuthorizedUser(){
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if(!(auth instanceof AnonymousAuthenticationToken)){
      User user = userRepository.findByUsername(auth.getName()).orElse(null);
      if(user!=null){
        return user;
      }else{
        throw new UsernameNotFoundException("User not found");
      }
    }else{
      throw new UsernameNotFoundException("No logged in user");
    }
  }
}
