package com.h33kz.WarehouseManagementSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h33kz.WarehouseManagementSystem.models.User;
import com.h33kz.WarehouseManagementSystem.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;
  
  @PostMapping("/add")
  public User addUser(@RequestBody User user){
    return userService.addUser(user);
  }

  @PostMapping("/remove")
  public void removeUser(@RequestBody String username){
    userService.removeUser(username);
  }


  @PostMapping("/changePassword")
  public User changePassword(@RequestBody String password){
    return userService.changePasswordForCurrentlyLoggedUser(password);
  }

  @PostMapping("/changeEmail")
  public User changeEmail(@RequestBody String email){
    return userService.changeEmailForCurrentlyLoggedUser(email);
  }

  @PostMapping("/changeRoles")
  public User changeRoles(@RequestBody String roles){
    return userService.changeRolesForCurrentlyLoggedUser(roles);
  }
}
