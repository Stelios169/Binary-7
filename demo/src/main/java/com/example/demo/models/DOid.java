/*
 * Copyright 2024-2025 Binary 7
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

 package com.example.demo.models;

 import lombok.Data;
 import java.io.Serializable;
 import java.util.Objects;
 
 import jakarta.persistence.Embeddable;
 
 @Embeddable
 @Data
 public class DOid implements Serializable {
     private int order_id;
     private int dish_id;
 
    public DOid() {
    }
    
     // Correct constructor to initialize fields
     public DOid(int order_id, int dish_id) {
         this.order_id = order_id;
         this.dish_id = dish_id;
     }
 
     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         DOid dOid = (DOid) o;
         return dish_id == dOid.dish_id && order_id == dOid.order_id;
     }
 
     @Override
     public int hashCode() {
         return Objects.hash(dish_id, order_id);
     }
 }
 