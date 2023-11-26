package com.h33kz.WarehouseManagementSystem.exceptions;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String message){
    super(message);
  }  
}
