package com.h33kz.WarehouseManagementSystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.SecondaryTables;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SecondaryTables({
  @SecondaryTable(name = "stock", pkJoinColumns = @PrimaryKeyJoinColumn(name = "product_id")),
  @SecondaryTable(name = "prices", pkJoinColumns = @PrimaryKeyJoinColumn(name = "product_id"))
})
public class Product{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private ProductCategory category;

  @Column(name = "price", table = "prices")
  private double price;
  
  @Column(name = "amount", table = "stock")
  private long amount;
}
