package com.h33kz.WarehouseManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @PostMapping("/insert")
  public Product insertProduct(@RequestBody Product product){
    return productService.insertProduct(product);
  }
  
  @GetMapping("/delete/{id}")
  public Product removeProduct(@PathVariable int id){
    return productService.removeProduct(id);
  }

  @GetMapping("/getOrdered/id")
  public List<Product> getAllById(){
    return productService.getAllById();
  }

  @GetMapping("/getOrdered/price")
  public List<Product> getAllByPrice(){
    return productService.getAllByPrice();
  }

  @GetMapping("/getOrdered/amount")
  public List<Product> getAllByAmount(){
    return productService.getAllByAmount();
  }

  @GetMapping("/getWith/price/between/{startPrice}/{endPrice}")
  public List<Product> getAllWithPriceBetween(@PathVariable(name = "startPrice") double startPrice, @PathVariable(name = "endPrice") double endPrice){
    return productService.getAllWithPriceBetween(startPrice, endPrice);
  }

  @GetMapping("/getWith/price/lower/{endPrice}")
  public List<Product> getAllWithPriceLowerThan(@PathVariable(name = "endPrice") double endPrice){
    return productService.getAllWithPriceLowerThan(endPrice);
  }

  @GetMapping("/getWith/price/higher/{startPrice}")
  public List<Product> getAllWithPriceHigherThan(@PathVariable(name = "startPrice") double startPrice){
    return productService.getAllWithPriceHigherThan(startPrice);
  }

  @GetMapping("/getWith/amount/between/{startAmount}/{endAmount}")
  public List<Product> getAllWithAmountBetween(@PathVariable(name = "startAmount") long startAmount, @PathVariable(name = "endAmount") long endAmount){
    return productService.getAllWithAmountBetween(startAmount, endAmount);
  }

  @GetMapping("/getWith/amount/lower/{endAmount}")
  public List<Product> getAllWithAmountLowerThan(@PathVariable(name = "endAmount") long endAmount){
    return productService.getAllWithAmountLowerThan(endAmount);
  }

  @GetMapping("/getWith/amount/higher/{startAmount}")
  public List<Product> getAllWithAmountHigherThan(@PathVariable(name = "startAmount") long startAmount){
    return productService.getAllWithAmountHigherThan(startAmount);
  }

  @GetMapping("/getWith/name/{searchString}")
  public List<Product> getProductsWithName(@PathVariable String searchString){
    return productService.getProductsWithName(searchString);
  }

  @GetMapping("/getWith/category/{category}")
  public List<Product> getProductsWithCategory(@PathVariable ProductCategory category){
    return productService.getProductsWithCategory(category);
  }

  @GetMapping("/getProduct/{id}")
  public Product getProductById(@PathVariable int id){
    return productService.getProductById(id);
  }

  @GetMapping("/getAmount/{id}")
  public long getAmountById(@PathVariable int id){
    return productService.getAmountById(id);
  }

  @GetMapping("/getPrice/{id}")
  public double getPriceById(@PathVariable int id){
    return productService.getPriceById(id);
  }
  
  @GetMapping("/update/amount/{id}/{amount}")
  public int updateAmountById(@PathVariable(name = "amount") long amount, @PathVariable(name = "id") int id){
    return productService.updateAmountById(amount, id);
  }

  @GetMapping("/update/price/{id}/{price}")
  public int updatePriceById(@PathVariable(name = "price") double price, @PathVariable(name = "id") int id){
    return productService.updatePriceById(price, id);
  }
}
