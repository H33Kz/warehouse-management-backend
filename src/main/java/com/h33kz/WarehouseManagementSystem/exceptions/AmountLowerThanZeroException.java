package com.h33kz.WarehouseManagementSystem.exceptions;

public class AmountLowerThanZeroException extends RuntimeException{
  public AmountLowerThanZeroException(String message){
    super(message);
  }
}
