package com.example.librarySystem.repositories;

import com.example.librarySystem.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    boolean existsByName(String name);
}
