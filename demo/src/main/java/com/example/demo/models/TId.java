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

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Embeddable
@Data
public class TId implements Serializable {
    private int table_id;
    private int restaurant_id;

    public TId() {
    }

    public TId(int table_id, int restaurant_id) {
        this.table_id = table_id;
        this.restaurant_id = restaurant_id;
    }
}
