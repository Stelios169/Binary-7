package com.example.demo.models;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;
import lombok.Data;

@Embeddable
@NoArgsConstructor
@Data 
public class RDId implements Serializable{
    private int restaurant_id;
    private int dish_id;   
}
