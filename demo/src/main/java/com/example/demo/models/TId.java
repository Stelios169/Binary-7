package com.example.demo.models;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Embeddable
@Data
public class TId implements Serializable {
    private int table_id;
    private int restaurant_id;
}
