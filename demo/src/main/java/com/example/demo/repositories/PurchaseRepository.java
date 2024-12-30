package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Purchase;
 
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
   
}
