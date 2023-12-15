package com.h33kz.WarehouseManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h33kz.WarehouseManagementSystem.models.Order;
import com.h33kz.WarehouseManagementSystem.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
  
  @Autowired
  private OrderService orderService;
  
  @PostMapping("/insert")
  public Order insertOrder(@RequestBody Order order){
    return orderService.insertOrder(order);
  }

  @GetMapping("/remove/{id}")
  public Order removeOrder(@PathVariable int id){
    return orderService.removeOrder(id);
  }

  @GetMapping("/get/{id}")
  public Order getOrderWithId(@PathVariable int id){
    return orderService.getOrderById(id);
  }
 
  @GetMapping("/getOrdered/id")
  public List<Order> getAllById(){
    return orderService.getAllById();
  }

  @GetMapping("/getOrdered/date")
  public List<Order> getAllByDate(){
    return orderService.getAllByDate();
  }

  @GetMapping("/getWith/{customerId}")
  public List<Order> getAllWithCustomer(@PathVariable int customerId){
    return orderService.getALlWithCustomer(customerId);
  }
}
