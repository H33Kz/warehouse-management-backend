package com.h33kz.WarehouseManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h33kz.WarehouseManagementSystem.models.Product;
import com.h33kz.WarehouseManagementSystem.repository.ProductRepository;


@Service
public class ProductService{
  @Autowired
  ProductRepository productRepository;
 
  //Insert new product to database
  public void insertProduct(Product product){
    productRepository.save(product);
    return;
  }

  //Get list of all products currently in database
  public List<Product> getAll(){
    return productRepository.findAll();
  }

  //Get product from database by index
  public Product getProduct(int index){
    return productRepository.findById(index).orElse(null);
  }

  //Get amount of a product in stock by index
  public long getAmount(int index){
    Product product = productRepository.findById(index).orElse(null);
    return (product == null) ? -1 : product.getAmount(); 
  }

  //Get price of a product by index
  public double getPrice(int index){
    Product product = productRepository.findById(index).orElse(null);
    return (product == null) ? -1.0 : product.getPrice();
  }
  
  //Set amount of a product in stock by index
  public int updateAmount(long additionalAmount, int index){
    Product product = productRepository.findById(index).orElse(null);
    if(product != null){
      if((product.getAmount() + additionalAmount) >= 0){
        product.setAmount(product.getAmount() + additionalAmount);
      }else{
        product.setAmount(0);
      }
      productRepository.save(product);
      return 1;
    }else{
      return -1;
    }
  }
}
