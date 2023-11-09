package com.h33kz.WarehouseManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h33kz.WarehouseManagementSystem.models.Product;
import com.h33kz.WarehouseManagementSystem.models.ProductCategory;
import com.h33kz.WarehouseManagementSystem.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  ProductService productService;

  @GetMapping("/get")
  public Product getProduct(){
    return new Product();
  }

  @GetMapping("/insert")
  public void insertProduct(){
    Product product = new Product();
    product.setName("Test");
    product.setCategory(ProductCategory.TYPE1);
    product.setAmount(4);
    productService.insertProduct(product);
  }

  @GetMapping("/getAmount")
  public long getAmount(){
    return productService.getAmount(1);
  }

  @GetMapping("/getAll")
  public List<Product> getAll(){
    return productService.getAll();
  }
}
