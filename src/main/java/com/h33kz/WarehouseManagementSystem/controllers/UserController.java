package com.h33kz.WarehouseManagementSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping("/test")
  public String test(){
    return "Test";
  }
  
}
