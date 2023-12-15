package com.h33kz.WarehouseManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h33kz.WarehouseManagementSystem.exceptions.OrderNotFoundException;
import com.h33kz.WarehouseManagementSystem.models.Customer;
import com.h33kz.WarehouseManagementSystem.models.Order;
import com.h33kz.WarehouseManagementSystem.models.OrderedItem;
import com.h33kz.WarehouseManagementSystem.models.Product;
import com.h33kz.WarehouseManagementSystem.repository.OrderRepository;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private ProductService productService;
  @Autowired
  private CustomerService customerService;

  
  public Order insertOrder(Order order){
    //Check if customer in placed order is present in database. If not create record for that customer when possible, otherwise throw exception
    Customer foundCustomer = customerService.getCustomerById(order.getCustomer().getId());
    if(foundCustomer==null){
      customerService.insertCustomer(order.getCustomer());
    }else{
      order.setCustomer(foundCustomer);
    }

    //Check if products listed in order are present in database, if not throw exception
    for(OrderedItem orderedItem : order.getOrderedItems()){
      Product product = productService.getProductById(orderedItem.getProduct().getId());
      orderedItem.setProduct(product);
    }

    return orderRepository.save(order);
  }

  public Order removeOrder(int id){
    Order order = orderRepository.findById(id).orElse(null);
    if(order!=null){
      orderRepository.delete(order);
    }else{
      throw new OrderNotFoundException("Order with that Id does not exist: " + id);
    }
    return order;
  }

  public List<Order> getAllById(){
    return orderRepository.findAll();
  }

  public List<Order> getAllByDate(){
    return orderRepository.findByOrderByDate();
  }

  public List<Order> getALlWithCustomer(int customerId){
    Customer customer = customerService.getCustomerById(customerId);
    return orderRepository.findByCustomer(customer);
  }

  public Order getOrderById(int id){
    return orderRepository.findById(id).orElse(null);
  }


}
