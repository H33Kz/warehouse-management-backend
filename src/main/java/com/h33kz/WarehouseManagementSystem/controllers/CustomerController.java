package com.h33kz.WarehouseManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h33kz.WarehouseManagementSystem.models.Customer;
import com.h33kz.WarehouseManagementSystem.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
  @Autowired
  private CustomerService customerService;

  @PostMapping("/insert")
  public Customer insertCustomer(@RequestBody Customer customer){
    return customerService.insertCustomer(customer);
  }

  @GetMapping("/remove/{id}")
  public Customer removeCustomer(@PathVariable int id){
    return customerService.removeCustomer(id);
  }

  @GetMapping("/get/{id}")
  public Customer getCustomerById(@PathVariable int id){
    return customerService.getCustomerById(id);
  }

  @GetMapping("/getOrdered/id")
  public List<Customer> getAllById(){
    return customerService.getAllById();
  }

  @GetMapping("/getWith/name/{searchString}")
  public List<Customer> getCustomersWithName(@PathVariable String searchString){
    return customerService.getCustomersWithName(searchString);
  }

  @GetMapping("/getWith/eg/{eg}")
  public List<Customer> getCustomerWithEg(@PathVariable long searchNumber){
    return customerService.getCustomerWithEg(searchNumber);
  }

  @GetMapping("/update/name/{id}/{newName}")
  public Customer updateCustomerNameById(@PathVariable(name = "id") int id, @PathVariable(name = "newName") String newName){
    return customerService.updateCustomerNameById(id, newName);
  }

  @GetMapping("/update/eg/{id}/{newEg}")
  public Customer updateCustomerEGById(@PathVariable(name = "id") int id, @PathVariable(name = "newEg") long newEg){
    return customerService.updateCustomerEGById(id, newEg);
  }
  
}
