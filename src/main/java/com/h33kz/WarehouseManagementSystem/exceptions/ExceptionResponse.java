package com.h33kz.WarehouseManagementSystem.exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExceptionResponse {
  private final String message;
  private final HttpStatus status;
  private final ZonedDateTime timestamp;
  
}
