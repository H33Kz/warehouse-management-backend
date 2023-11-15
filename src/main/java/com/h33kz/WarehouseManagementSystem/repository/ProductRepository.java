package com.h33kz.WarehouseManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.h33kz.WarehouseManagementSystem.models.Product;
import com.h33kz.WarehouseManagementSystem.models.ProductCategory;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
  List<Product> findByNameContaining(String infix);
  List<Product> findByCategory(ProductCategory category);
  List<Product> findByOrderByPrice();
  List<Product> findByOrderByAmount();
  List<Product> findByPriceBetween(double startPrice, double endPrice);
  List<Product> findByAmountBetween(long startAmount, long endAmount);
}
