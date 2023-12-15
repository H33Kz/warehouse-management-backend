package com.h33kz.WarehouseManagementSystem.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = {
    ProductNotFoundException.class,
    UserNotFoundException.class,
    CustomerNotFoundException.class,
    OrderNotFoundException.class
  })
  public ResponseEntity<Object> handleResourceNotFoundException(Exception e){
    ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now(ZoneId.of("Z")));
    return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler(value = {
    PriceLowerThanZeroException.class, 
    AmountLowerThanZeroException.class, 
    UserAlreadyExistsException.class, 
    CustomerWithThatEGExistsException.class
  })
  public ResponseEntity<Object> handleInproperRequestValueException(Exception e){
    ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage(), HttpStatus.CONFLICT, ZonedDateTime.now(ZoneId.of("Z")));
    return new ResponseEntity<>(exceptionResponse,HttpStatus.CONFLICT);
  }
}
