package com.h33kz.WarehouseManagementSystem.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h33kz.WarehouseManagementSystem.models.Pipe;

@RestController
@RequestMapping("/pipes")
public class PipeController {
  @GetMapping("/get")
  public Pipe getPipe(){
    return new Pipe();
  }
}
