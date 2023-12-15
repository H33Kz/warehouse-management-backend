package com.h33kz.WarehouseManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.h33kz.WarehouseManagementSystem.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
  List<Customer> findByNameContaining(String infix);
  List<Customer> findByCompanyEgContaining(long infix);
  List<Customer> findByCompanyEg(long eg);
}
