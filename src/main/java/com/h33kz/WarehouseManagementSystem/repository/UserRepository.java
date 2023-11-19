package com.h33kz.WarehouseManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.h33kz.WarehouseManagementSystem.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
}
