package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class RTable {
    @EmbeddedId
    private TId tableId;

    @ManyToOne
    @MapsId("restaurant_id")
    @JoinColumn(name = "Restaurant_Id")
    private Restaurant restaurant;
    @OneToMany(mappedBy = "table", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> orders = new ArrayList<>();    
}
