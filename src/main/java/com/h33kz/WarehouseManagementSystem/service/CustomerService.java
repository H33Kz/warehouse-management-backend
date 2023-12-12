package com.h33kz.WarehouseManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h33kz.WarehouseManagementSystem.exceptions.CustomerNotFoundException;
import com.h33kz.WarehouseManagementSystem.exceptions.CustomerWithThatEGExistsException;
import com.h33kz.WarehouseManagementSystem.models.Customer;
import com.h33kz.WarehouseManagementSystem.repository.CustomerRepository;

@Service
public class CustomerService {
  @Autowired
  private CustomerRepository customerRepository;

  public Customer insertCustomer(Customer customer){
    if(customerRepository.findByCompanyEg(customer.getCompanyEg())!=null){
      throw new CustomerWithThatEGExistsException("Company's EG is already in use");
    }
    return customerRepository.save(customer);
  }

  public Customer removeCustomer(int id){
    Customer customer = customerRepository.findById(id).orElse(null);
    if(customer!=null){
      customerRepository.delete(customer);
    }else{
      throw new CustomerNotFoundException("Customer with that ID does not exist");
    }
    return customer;
  }

  public List<Customer> getCustomersWithName(String infix){
    return customerRepository.findByNameContaining(infix);
  }

  public Customer updateCustomerNameById(int id, String newName){
    Customer customer = customerRepository.findById(id).orElse(null);
    if(customer!=null){
      customer.setName(newName);
      return customerRepository.save(customer);
    }
    else{
      throw new CustomerNotFoundException("Customer with that ID does not exist");
    }
  }

  public Customer updateCustomerEGById(int id, long newEG){
    Customer customer = customerRepository.findById(id).orElse(null);
    if(customer!=null){
      if(customerRepository.findByCompanyEg(newEG)==null){
        customer.setCompanyEg(newEG);
        return customerRepository.save(customer);
      }else{
        throw new CustomerWithThatEGExistsException("Company's EG is already in use");
      }
    }else{
      throw new CustomerNotFoundException("Customer with that ID does not exist");
    }
  }
}
