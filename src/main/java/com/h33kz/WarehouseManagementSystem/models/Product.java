package com.h33kz.WarehouseManagementSystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SecondaryTable(name = "stock", pkJoinColumns = @PrimaryKeyJoinColumn(name = "product_id"))
public class Product{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private ProductVariant variant;
  private MaterialType materialType;
  private double thickness;
  private double price;
  
  @Column(name = "amount", table = "stock")
  private long amount;
}
