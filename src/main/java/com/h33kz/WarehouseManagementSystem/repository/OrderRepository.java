package com.h33kz.WarehouseManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.h33kz.WarehouseManagementSystem.models.Customer;
import com.h33kz.WarehouseManagementSystem.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{
  List<Order> findByCustomer(Customer customer);
  List<Order> findByOrderByDate();
}
