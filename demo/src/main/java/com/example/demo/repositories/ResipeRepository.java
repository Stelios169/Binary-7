package com.example.demo.repositories;

import com.example.demo.models.Recipe;
import java.util.List;

public interface ResipeRepository {
    List<Recipe> findAll();
}
