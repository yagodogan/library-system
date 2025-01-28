package com.example.librarySystem.repository;

import com.example.librarySystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    boolean existsByName(String name);
}
