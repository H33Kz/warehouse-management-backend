package com.h33kz.WarehouseManagementSystem.exceptions;

public class PriceLowerThanZeroException extends RuntimeException{
  public PriceLowerThanZeroException(String message){
    super(message);
  }
}
