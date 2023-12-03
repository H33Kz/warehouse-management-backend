package com.h33kz.WarehouseManagementSystem.exceptions;

public class ProductNotFoundException extends RuntimeException{
  public ProductNotFoundException(String message){
    super(message);
  }
}
