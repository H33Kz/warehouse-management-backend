package com.h33kz.WarehouseManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h33kz.WarehouseManagementSystem.models.Product;
import com.h33kz.WarehouseManagementSystem.models.ProductCategory;
import com.h33kz.WarehouseManagementSystem.repository.ProductRepository;


@Service
public class ProductService{
  @Autowired
  ProductRepository productRepository;
 
  //Insert new product to database
  public Product insertProduct(Product product){
    return productRepository.save(product);
  }

  public Product removeProduct(int index){
    Product product = productRepository.findById(index).orElse(null);
    if(product != null){
      productRepository.delete(product);
    }
    return product;
  }

  //Get list of all products sorted by id
  public List<Product> getAllById(){
    return productRepository.findAll();
  }

  //Get list of all products sorted by price
  public List<Product> getAllByPrice(){
    return productRepository.findByOrderByPrice();
  }

  //Get list of all products sorted by amount in stock
  public List<Product> getAllByAmount(){
    return productRepository.findByOrderByAmount();
  }

  //Get list of products with price between set values
  public List<Product> getAllWithPriceBetween(double startPrice, double endPrice){
    return productRepository.findByPriceBetween(startPrice, endPrice);
  }

  //Get list of products with price not higher than set value
  public List<Product> getAllWithPriceLowerThan(double endPrice){
    return productRepository.findByPriceBetween(0.0, endPrice);
  }

  //Get list of products with price higher than set value
  public List<Product> getAllWithPriceHigherThan(double startPrice){
    return productRepository.findByPriceBetween(startPrice, Double.MAX_VALUE);
  }

  //Get list of products with amount between set values
  public List<Product> getAllWithAmountBetween(long startAmount, long endAmount){
    return productRepository.findByAmountBetween(startAmount, endAmount);
  }

  //Get list of products with amount not higher than set value
  public List<Product> getAllWithAmountLowerThan(long endAmount){
    return productRepository.findByAmountBetween(0, endAmount);
  }

  //Get list of products with amount higher than set value
  public List<Product> getAllWithAmountHigherThan(long startAmount){
    return productRepository.findByAmountBetween(startAmount, Long.MAX_VALUE);
  }

  //Get list of products with specified name
  public List<Product> getProductsWithName(String searchString){
    return productRepository.findByNameContaining(searchString); 
  }

  //Get list of products in specified category
  public List<Product> getProductsWithCategory(ProductCategory category){
    return productRepository.findByCategory(category);
  }

  //Get product from database by index
  public Product getProductById(int index){
    return productRepository.findById(index).orElse(null);
  }

  //Get amount of a product in stock by index
  public long getAmountById(int index){
    Product product = productRepository.findById(index).orElse(null);
    return (product == null) ? -1 : product.getAmount(); 
  }

  //Get price of a product by index
  public double getPriceById(int index){
    Product product = productRepository.findById(index).orElse(null);
    return (product == null) ? -1.0 : product.getPrice();
  }
  
  //Set amount of a product in stock by index
  public int updateAmountById(long additionalAmount, int index){
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
  
  //Set new price of a product in stock by index
  public int updatePriceById(double newPrice, int index){
    Product product = productRepository.findById(index).orElse(null);
    if(product != null){
      if(newPrice >= 0){
        product.setPrice(newPrice);
        productRepository.save(product);
        return 1;
      }else{
        return -1;
      }
    }else{
      return -1;
    }
  }
}
