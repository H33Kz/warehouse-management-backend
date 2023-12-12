package com.h33kz.WarehouseManagementSystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderedItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private int quantity;

  @ManyToOne
  private Order order;
}
