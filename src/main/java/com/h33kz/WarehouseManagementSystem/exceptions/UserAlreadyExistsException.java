package com.h33kz.WarehouseManagementSystem.exceptions;

public class UserAlreadyExistsException extends RuntimeException{
  public UserAlreadyExistsException(String message){
    super(message);
  }
}
