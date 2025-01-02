package com.example.demo.repositories;

import com.example.demo.models.RTable;
import com.example.demo.models.TId;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface RTableRepository extends JpaRepository<RTable, TId> {
 
}
 
